package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

import models.Categoria;
import models.Libro;
import services.CategoriaService;
import services.LibroService;
import services.impl.CategoriaServiceImpl;
import services.impl.LibroServiceImpl;



@WebServlet("/libros")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final LibroService libroService;

    
    public LibroServlet() {
        super();
        libroService = new LibroServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer idSubcategoria = null;
    	List<Libro> libros;
    	 String idLibroParam = request.getParameter("id"); // Parámetro para obtener un libro específico

         try {
             if (idLibroParam != null) { // Si se solicita un libro específico
                 int idLibro = Integer.parseInt(idLibroParam);
                 Libro libro = libroService.obtenerLibroPorId(idLibro);

                 if (libro != null) {
                     request.setAttribute("libro", libro);
                     RequestDispatcher dispatcher = request.getRequestDispatcher("/views/detallelibro.jsp");
                     dispatcher.forward(request, response);
                     return;
                 } else {
                     // Si no se encuentra el libro, redirigir a un error o a la lista
                     request.setAttribute("error", "Libro no encontrado");
                     RequestDispatcher dispatcher = request.getRequestDispatcher("/views/libros.jsp");
                     dispatcher.forward(request, response);
                     return;
                 }
             } else if (request.getParameter("idSubcategoria") != null) { // Si se solicita por subcategoría
                 idSubcategoria = Integer.parseInt(request.getParameter("idSubcategoria"));
                 libros = libroService.listarLibrosPorIdSubcategoria(idSubcategoria);
             } else {
                 // Si no hay parámetros de filtro, mostramos todos los libros
                 libros = libroService.listarLibros();
             }
         } catch (NumberFormatException | NullPointerException e) {
             libros = libroService.listarLibros(); // Si hay error, mostramos todos los libros
             e.printStackTrace(); // Para depuración
         }

         request.setAttribute("libros", libros);
         RequestDispatcher dispatcher = request.getRequestDispatcher("/views/libros.jsp");
         dispatcher.forward(request, response);
     }

    // Método para insertar libros
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idEditorial = Integer.parseInt(request.getParameter("idEditorial"));
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            int anioPublicacion = Integer.parseInt(request.getParameter("anioPublicacion"));
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String estado = request.getParameter("estado");
            String estadoAuditoria = request.getParameter("estadoAuditoria");
            Date fechaCreacion = new java.sql.Date(System.currentTimeMillis()); // ✅ Fecha actual en formato SQL

            // Crear un objeto Libro
            Libro libro = new Libro();
            libro.setIdEditorial(idEditorial);
            libro.setIdCategoria(idCategoria);
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setAnioPublicacion(anioPublicacion);
            libro.setCodigo(codigo);
            libro.setDescripcion(descripcion);
            libro.setEstado(estado);
            libro.setEstadoAuditoria(estadoAuditoria);
            libro.setFechaCreacion(fechaCreacion);

            libroService.insertarLibro(libro);
            response.sendRedirect("libros");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al insertar el libro.");
            doGet(request, response);
        }
    }
}

