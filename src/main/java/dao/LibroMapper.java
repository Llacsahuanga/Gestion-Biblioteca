package dao;

import java.util.List;

import models.Libro;

public interface LibroMapper {
	
	List<Libro> listarLibros();  // Método para listar todos los libros
    void insertarLibro(Libro libro);

}
