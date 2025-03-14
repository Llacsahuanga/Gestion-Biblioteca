package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Libro;
import services.LibroService;
import services.impl.LibroServiceImpl;

import com.google.gson.Gson;
/**
 * Servlet implementation class PrestamoServlet
 */
@WebServlet("/Prestamo")
public class PrestamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final LibroService libroService;

    public PrestamoServlet() {
        super();
        this.libroService = new LibroServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estado = request.getParameter("estado");
        List<Libro> librosFiltrados = libroService.filtrarPorEstado(estado);
        
        request.setAttribute("libros", librosFiltrados);
        request.getRequestDispatcher("views/prestamos.jsp").forward(request, response);
    }
}




