package services;

import java.util.List;


import models.Libro;

public interface LibroService {
	

	List<Libro> listarLibros();  
    void insertarLibro(Libro libro);
}
