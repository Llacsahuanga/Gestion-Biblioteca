package services;

import java.util.List;


import models.Libro;

public interface LibroService {
	
	List<Libro> listarLibros();  // Método para listar todos los libros
    void insertarLibro(Libro libro);
}
