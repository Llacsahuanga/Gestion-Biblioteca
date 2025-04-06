package services.impl;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.DetallePrestamoMapper;
import models.DetallePrestamo;
import services.DetallePrestamoService;

public class DetallePrestamoServiceImpl implements DetallePrestamoService{

	@Override
	public DetallePrestamo obtenerDetallePrestamoPorIdPrestamoYIdLibro(Integer idPrestamo, Integer idLibro) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			DetallePrestamoMapper detallePrestamoMapper = session.getMapper(DetallePrestamoMapper.class);
			return detallePrestamoMapper.obtenerDetallePrestamoPorIdPrestamoYIdLibro(idPrestamo, idLibro);
		} catch (Exception e) {
			System.out.println("obtenerDetallePrestamoPorIdPrestamoYIdLibro::"+e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DetallePrestamo insertarDetallePrestamo(DetallePrestamo detallePrestamo) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			DetallePrestamoMapper detallePrestamoMapper = session.getMapper(DetallePrestamoMapper.class);
			detallePrestamoMapper.insertarDetallePrestamo(detallePrestamo);
			session.commit();
			return detallePrestamo;
		} catch (Exception e) {
			System.out.println("insertarDetallePrestamo::"+e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void aumentarDetallePrestamoCantidad(Integer idDetallePrestamo) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			DetallePrestamoMapper detallePrestamoMapper = session.getMapper(DetallePrestamoMapper.class);
			detallePrestamoMapper.aumentarDetallePrestamoCantidad(idDetallePrestamo);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertarDetallePrestamo::"+e);
			e.printStackTrace();
		}
	}

}
