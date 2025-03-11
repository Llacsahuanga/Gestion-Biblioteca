package dao;

import java.util.List;

import models.Libro;

public interface LibroMapper {

	List<Libro> listarLibros();  
    void insertarLibro(Libro libro);
}
	   
