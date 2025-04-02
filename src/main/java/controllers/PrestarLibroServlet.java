package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrestarLibroServlet
 */
@WebServlet("/prestar")
public class PrestarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrestarLibroServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/prestarlibro.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idLibro = Integer.parseInt(request.getParameter("idLibro"));
		System.out.println("Se esta agregando un prestamo: "+idLibro);
		
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("cookie: "+cookie.getName()+ " - " + cookie.getValue());
		}
		
		
		
		response.getWriter().append("OK");
		
	}

}
