package services;

import models.DetallePrestamo;

public interface DetallePrestamoService {

	
	DetallePrestamo obtenerDetallePrestamoPorIdPrestamoYIdLibro(Integer idPrestamo, Integer idLibro);
	DetallePrestamo insertarDetallePrestamo(DetallePrestamo detallePrestamo);
	void aumentarDetallePrestamoCantidad(Integer idDetallePrestamo);

	
}
