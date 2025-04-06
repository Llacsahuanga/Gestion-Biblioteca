package services;

import java.util.List;

import models.Reserva;

public interface ReservaService {
	
	 List<Reserva> ListarReservas();
	 
	 void guardarReserva(Reserva reserva);

}
