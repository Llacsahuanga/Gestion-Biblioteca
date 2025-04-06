package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibir los datos del formulario
        int idEjemplar = Integer.parseInt(request.getParameter("idEjemplar"));
        String estado = request.getParameter("estado");
        String imagenUrl = request.getParameter("imagen");  // La URL de la imagen proporcionada por el usuario

     // Crear una nueva reserva con los datos recibidos
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setIdEjemplar(idEjemplar);
        nuevaReserva.setEstado(estado);
        nuevaReserva.setImagenUrl(imagenUrl);  // Usar la URL proporcionada
        // No es necesario asignar la fecha manualmente


        // Guardar la reserva en la base de datos
        reservaService.guardarReserva(nuevaReserva);

        // Redirigir a la lista de reservas después de guardar
        response.sendRedirect("/Gestion-Biblioteca/reserva");
    }

}
