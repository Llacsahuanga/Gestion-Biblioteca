package models;

import java.sql.Date;

public class DetallePrestamo {
	
	private Integer idDetallePrestamo;
	private Integer idPrestamo;
	private Integer idEjemplar;
	private Date fechaDevolucionPrevista;
	private Date fechaDevolucionReal;
	private String estado;
	private String estadoAuditoria;
	private Date fechaCreacion;
	private Integer cantidad;
	private Integer idLibro;
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public Integer getIdDetallePrestamo() {
		return idDetallePrestamo;
	}
	public void setIdDetallePrestamo(Integer idDetallePrestamo) {
		this.idDetallePrestamo = idDetallePrestamo;
	}
	public Integer getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public Integer getIdEjemplar() {
		return idEjemplar;
	}
	public void setIdEjemplar(Integer idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	public Date getFechaDevolucionPrevista() {
		return fechaDevolucionPrevista;
	}
	public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
		this.fechaDevolucionPrevista = fechaDevolucionPrevista;
	}
	public Date getFechaDevolucionReal() {
		return fechaDevolucionReal;
	}
	public void setFechaDevolucionReal(Date fechaDevolucionReal) {
		this.fechaDevolucionReal = fechaDevolucionReal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoAuditoria() {
		return estadoAuditoria;
	}
	public void setEstadoAuditoria(String estadoAuditoria) {
		this.estadoAuditoria = estadoAuditoria;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
