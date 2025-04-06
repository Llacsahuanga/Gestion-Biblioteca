package dao;

import org.apache.ibatis.annotations.Param;

import models.DetallePrestamo;

public interface DetallePrestamoMapper {
	
	DetallePrestamo obtenerDetallePrestamoPorIdPrestamoYIdLibro(@Param("idPrestamo") Integer idPrestamo,@Param("idLibro") Integer idLibro);
	void insertarDetallePrestamo(DetallePrestamo detallePrestamo);
	void aumentarDetallePrestamoCantidad(Integer idDetallePrestamo);

}
