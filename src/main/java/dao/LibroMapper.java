package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import models.Libro;

public interface LibroMapper {

	List<Libro> listarLibros();  
    void insertarLibro(Libro libro);
    List<Libro> listarLibrosPorIdSubcategoria(Integer idSubcategoria);
    List<Libro> filtrarPorEstado(@Param("estado") String estado);
}
	   
