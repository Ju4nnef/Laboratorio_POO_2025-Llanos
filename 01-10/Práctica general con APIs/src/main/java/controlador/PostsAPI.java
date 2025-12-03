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

@WebServlet("/posts")
public class PostsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostsAPI() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			String urlApi = "https://jsonplaceholder.typicode.com/posts/1";
			URL url = new URL(urlApi);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setRequestProperty("Accept", "application/json");

			if (conexion.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				String linea;
				StringBuilder respuestaApi = new StringBuilder();
				
				while ((linea = br.readLine()) != null) {
					respuestaApi.append(linea);
				}
				br.close();
				

				out.println("<html>");
				out.println("<body style='font-family: sans-serif; text-align: center; margin-top: 50px;'>");
				
				out.println("<h1>📌 Datos traídos de la API</h1>");
				out.println("<div style='border: 1px solid #ccc; padding: 20px; display: inline-block; background-color: #f9f9f9;'>");
				
				out.println("<h3>Respuesta JSON Original:</h3>");
				out.println("<p>" + respuestaApi.toString() + "</p>");
				
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
				
			} else {
				out.println("<h1>Error al conectar con la API</h1>");
			}
			
			conexion.disconnect();

		} catch (Exception e) {
			out.println("<h3>Ocurrió un error: " + e.getMessage() + "</h3>");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}