package controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PruebaAPI {

	public static void main(String[] args) {
		try {
			String urlApi = "https://jsonplaceholder.typicode.com/posts/1";
			URL url = new URL(urlApi);
			
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setRequestProperty("Accept", "application/json");
			
			if (conexion.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				String linea;
				StringBuilder respuesta = new StringBuilder();
				
				while ((linea = br.readLine()) != null) {
					respuesta.append(linea);
				}
				br.close();
				
				System.out.println("--- RESPUESTA DE LA API ---");
				System.out.println(respuesta.toString());
				

				System.out.println("\n--- CAMPOS EXTRAÍDOS ---");
				String texto = respuesta.toString();
				
				int indexTitle = texto.indexOf("\"title\":");
				int indexBody = texto.indexOf("\"body\":");
				
				System.out.println("Se encontró el título en el índice: " + indexTitle);
				System.out.println("Cuerpo completo recibido.");
				
			} else {
				System.out.println("Error en la conexión: " + conexion.getResponseCode());
			}
			
			conexion.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}