package services.impl;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.PrestamoMapper;
import models.Prestamo;
import services.PrestamoService;

public class PrestamoServiceImpl implements PrestamoService{

	@Override
	public Prestamo obtenerPrestamoPorCodigoInterno(String codigoInterno) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			PrestamoMapper prestamoMapper = session.getMapper(PrestamoMapper.class);
			return prestamoMapper.obtenerPrestamoPorCodigoInterno(codigoInterno);
		} catch (Exception e) {
			System.out.println("obtenerPrestamoPorCodigoInterno::"+e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Prestamo insertarPrestamo(Prestamo prestamo) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			PrestamoMapper prestamoMapper = session.getMapper(PrestamoMapper.class);
			prestamoMapper.insertarPrestamo(prestamo);
			session.commit();
			return prestamo;
		} catch (Exception e) {
			System.out.println("insertarPrestamo::"+e);
			e.printStackTrace();
			return null;
		}
	}

}
