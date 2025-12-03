package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clima")
public class ClimaCiudad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String API_KEY = "TU_API_KEY"; 
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public ClimaCiudad() {
        super();
    }
    
    private String clasificarEstado(double temperatura) {
    	if (temperatura < 10) {
    		return "frío";
    	} else if (temperatura >= 10 && temperatura <= 25) {
    		return "templado";
    	} else { 
    		return "caluroso";
    	}
    }
    
    private Double obtenerTemperatura(String ciudad) {
        
    		if (API_KEY.equals("TU_API_KEY")) {
            System.out.println("ADVERTENCIA: Usando datos SIMULADOS para la ciudad: " + ciudad + ".");
            System.out.println("Reemplace 'TU_API_KEY' con su clave real para obtener datos en vivo.");
            
            if (ciudad.toLowerCase().contains("aires")) return 23.5; 
            if (ciudad.toLowerCase().contains("ushuaia")) return 5.0; 
            
            return 30.0; 
        }

    	String urlApi = String.format("%s?q=%s&units=metric&appid=%s", BASE_URL, ciudad, API_KEY);
        
        try {
            URL url = new URL(urlApi);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            
            if (conexion.getResponseCode() != 200) {
                return null; 
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                respuesta.append(linea);
            }
            br.close();
            conexion.disconnect();
            
            String jsonRespuesta = respuesta.toString();
            
            int startIndex = jsonRespuesta.indexOf("\"temp\":");
            
            if (startIndex != -1) {
                startIndex += "\"temp\":".length();
                int endIndex = jsonRespuesta.indexOf(",", startIndex);
                
                String tempStr = jsonRespuesta.substring(startIndex, endIndex).trim();
                
                return Double.parseDouble(tempStr);
            }

        } catch (Exception e) {
            System.err.println("Error en la conexión o parsing de la API: " + e.getMessage());
        }
        
        return null; 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String ciudadParam = request.getParameter("ciudad");
		
		if (ciudadParam == null || ciudadParam.trim().isEmpty()) {
			String errorJson = "{ \"error\": \"El parámetro 'ciudad' es obligatorio.\" }";
			out.print(errorJson);
			out.flush();
			return; 
		}
		

		Double temperatura = obtenerTemperatura(ciudadParam);
		

		if (temperatura == null) {
			String errorJson = "{ \"error\": \"No se pudo obtener información del clima\" }";
			out.print(errorJson);
			out.flush();
			return; 
		}
		

		String estadoClasificado = clasificarEstado(temperatura); 
		
		String jsonFinal = String.format(
				"{ \"ciudad\": \"%s\", \"temperatura\": %.1f, \"estado\": \"%s\" }",
				ciudadParam, 
				temperatura, 
				estadoClasificado);
		
		out.print(jsonFinal);
		out.flush();
	}
}