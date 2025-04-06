package services;

import models.Prestamo;

public interface PrestamoService {
	
	Prestamo obtenerPrestamoPorCodigoInterno(String codigoInterno);
	Prestamo insertarPrestamo(Prestamo prestamo);

}
