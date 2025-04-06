package dao;

import models.Prestamo;

public interface PrestamoMapper {
	
	Prestamo obtenerPrestamoPorCodigoInterno(String codigoInterno);
	void insertarPrestamo(Prestamo prestamo);

}
