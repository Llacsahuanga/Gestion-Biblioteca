package dao;

import java.util.List;

import models.Subcategoria;

public interface SubcategoriaMapper {

	List<Subcategoria> listarSubcategoriasPorIdCategoria(Integer idCategoria); 
}
