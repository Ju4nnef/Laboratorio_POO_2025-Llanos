package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HolaAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HolaAPI() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String jsonResponse = "{ \"mensaje\": \"holiii omg mi primera api con tomcat increible\" }";
		out.print(jsonResponse);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}