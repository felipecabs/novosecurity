package cl.usm.novosec.ingreso.signature;

public class EditarInvitacionReq {
	private int id;
	private int rutOrigen;
	private int rutDestino;
	private String estado;
	
	public EditarInvitacionReq() {
		super();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	
}
