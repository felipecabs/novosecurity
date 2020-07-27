package cl.usm.novosec.ingreso.signature;

import java.sql.Date;

public class ListarInvitadosReq {
	
	private Date fechaInicio;
	private Date fechaTermino;
	
	public ListarInvitadosReq() {
		
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	
	
}
