package services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.SubcategoriaMapper;
import models.Subcategoria;
import services.SubcategoriaService;

public class SubcategoriaServiceImpl implements SubcategoriaService{

	@Override
	public List<Subcategoria> listarSubcategoriasPorIdCategoria(Integer idCategoria) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			SubcategoriaMapper subcategoriaMapper = session.getMapper(SubcategoriaMapper.class);
			return subcategoriaMapper.listarSubcategoriasPorIdCategoria(idCategoria);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
