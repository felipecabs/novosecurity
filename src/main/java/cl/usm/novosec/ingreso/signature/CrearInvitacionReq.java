package cl.usm.novosec.ingreso.signature;

import java.util.Date;

public class CrearInvitacionReq {
	private int rutOrigen;
	private int rutDestino;
	private String estado;
	private Date fecha;
	
	public CrearInvitacionReq() {
		super();
	}
	public int getRutOrigen() {
		return rutOrigen;
	}
	public void setRutOrigen(int rutOrigen) {
		this.rutOrigen = rutOrigen;
	}
	public int getRutDestino() {
		return rutDestino;
	}
	public void setRutDestino(int rutDestino) {
		this.rutDestino = rutDestino;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
