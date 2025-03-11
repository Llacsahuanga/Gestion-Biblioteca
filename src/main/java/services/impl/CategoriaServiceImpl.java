package services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.CategoriaMapper;
import models.Categoria;
import services.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

	@Override
	public List<Categoria> listarCategorias() {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			CategoriaMapper categoriaMapper = session.getMapper(CategoriaMapper.class);
			return categoriaMapper.listarCategorias();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void insertarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

}
