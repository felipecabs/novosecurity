package cl.usm.novosec.ingreso.signature;

public class AutorizarIngresoReq {
	
	private int idInvitacion;
	private boolean estadoAutorizacion;
	
	public AutorizarIngresoReq() {
	
	}

	public int getIdInvitacion() {
		return idInvitacion;
	}

	public void setIdInvitacion(int idInvitacion) {
		this.idInvitacion = idInvitacion;
	}

	public boolean isEstadoAutorizacion() {
		return estadoAutorizacion;
	}

	public void setEstadoAutorizacion(boolean estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
	}
	
	
	
}
