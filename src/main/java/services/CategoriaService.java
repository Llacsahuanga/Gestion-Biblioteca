package services;

import java.util.List;

import models.Categoria;

public interface CategoriaService {
	
	List<Categoria> listarCategorias();
	void insertarCategoria(Categoria categoria);

}
