package services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.ReservaMapper;
import models.Reserva;
import services.ReservaService;


public class ReservaServiceImpl implements ReservaService{

	@Override
	public List<Reserva> ListarReservas() {
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ReservaMapper mapper = session.getMapper(ReservaMapper.class);
            return mapper.listarReservas();
        }
	
	}

	@Override
	public void guardarReserva(Reserva reserva) {
		
		 try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
	            ReservaMapper mapper = session.getMapper(ReservaMapper.class);
	            mapper.insertarReserva(reserva);  // Este método debe ser implementado en tu mapper
	            session.commit();
	        }
	}

	
}


