package controllers;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DetallePrestamo;
import models.Prestamo;
import services.impl.DetallePrestamoServiceImpl;
import services.impl.PrestamoServiceImpl;

import shared.Util;

/**
 * Servlet implementation class PrestarLibroServlet
 */
@WebServlet("/prestar")
public class PrestarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private PrestamoServiceImpl prestamoServiceImpl;
	private DetallePrestamoServiceImpl detallePrestamoServiceImpl;
	
    public PrestarLibroServlet() {
        super();
        
         prestamoServiceImpl = new PrestamoServiceImpl();
    	 detallePrestamoServiceImpl = new DetallePrestamoServiceImpl();
    	 
    	
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/prestarlibro.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idLibro = Integer.parseInt(request.getParameter("idLibro"));
		System.out.println("Se esta agregando un prestamo: "+idLibro);
		
		
		String sessionId = Util.getCookieValue(request.getCookies(), "JSESSIONID");
		
		Prestamo prestamo = prestamoServiceImpl.obtenerPrestamoPorCodigoInterno(sessionId);
		if(prestamo==null) {
			Prestamo newPrestamo = new Prestamo();
			newPrestamo.setCodigoInterno(sessionId);
			prestamo = prestamoServiceImpl.insertarPrestamo(newPrestamo);
		}
		
		System.out.println("Prestamoid::"+prestamo.getIdPrestamo());
		
		DetallePrestamo detallePrestamo = detallePrestamoServiceImpl.obtenerDetallePrestamoPorIdPrestamoYIdLibro(prestamo.getIdPrestamo(), idLibro); 
		if(detallePrestamo == null) {
			DetallePrestamo newDetallePrestamo = new DetallePrestamo();
			newDetallePrestamo.setIdPrestamo(prestamo.getIdPrestamo());
			newDetallePrestamo.setIdLibro(idLibro);
			detallePrestamo = detallePrestamoServiceImpl.insertarDetallePrestamo(newDetallePrestamo);
		} else {
			detallePrestamoServiceImpl.aumentarDetallePrestamoCantidad(detallePrestamo.getIdDetallePrestamo());
		}
		
		System.out.println("DetallePrestamoId::"+detallePrestamo.getIdDetallePrestamo());
		
		
		/*
		 - capturar en un Sring el cookie de JSESSIONID con clase Util que recibe parametro Cookies[]
		 - buscar en la tabla ventas si ya existe ese cookie como codigoInterno
		 - si no existe, creo el reigstro en la tabla ventas
		 - agrego el producto, a la tabla venta_detalle ( pendiente conteo de cantidad )	 
		 * */
		
		response.getWriter().append("OK");
		
	}

}
