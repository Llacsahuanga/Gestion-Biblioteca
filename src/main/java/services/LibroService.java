package services;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import models.Libro;
import models.Libro;

public interface LibroService {
	
	List<Libro> listarLibrosPorIdSubcategoria(Integer idSubcategoria);
	List<Libro> listarLibros();  
    void insertarLibro(Libro libro);
    List<Libro> filtrarPorEstado(@Param("estado") String estado);
 
}
