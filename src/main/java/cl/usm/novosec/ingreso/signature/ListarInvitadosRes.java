package cl.usm.novosec.ingreso.signature;



import java.util.ArrayList;
import java.util.List;

import cl.usm.novosec.ingreso.model.Invitacion;

public class ListarInvitadosRes {
	private List<Invitacion> invitaciones;

	public ListarInvitadosRes() {
		this.invitaciones = new ArrayList<Invitacion>();
	}

	public List<Invitacion> getInvitaciones() {
		return invitaciones;
	}

	public void setInvitaciones(List<Invitacion> invitaciones) {
		this.invitaciones = invitaciones;
	}
	
}
