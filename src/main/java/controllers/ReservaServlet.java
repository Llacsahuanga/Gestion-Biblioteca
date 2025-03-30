package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reserva;
import services.LibroService;
import services.ReservaService;
import services.impl.LibroServiceImpl;
import services.impl.ReservaServiceImpl;

/**
 * Servlet implementation class ReservaServlet
 */
@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final ReservaService reservaService;
    
    public ReservaServlet() {
        super();
        
        reservaService = new ReservaServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Reserva> reservas = reservaService.ListarReservas();
        request.setAttribute("reservas", reservas);
        request.getRequestDispatcher("views/reservas.jsp").forward(request, response);
    }

}
