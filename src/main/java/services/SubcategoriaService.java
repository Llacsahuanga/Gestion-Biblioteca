package services;

import java.util.List;

import models.Subcategoria;

public interface SubcategoriaService {
	
	List<Subcategoria> listarSubcategoriasPorIdCategoria(Integer idCategoria); 

}
