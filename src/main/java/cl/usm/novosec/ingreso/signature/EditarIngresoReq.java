package cl.usm.novosec.ingreso.signature;

public class EditarIngresoReq {
	private int id;
	private int rutUsuario;
	private String tipo;
	private String estado;
	private int idEstacionamiento;
	private String comentarios;
	
	public EditarIngresoReq() {
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRutUsuario() {
		return rutUsuario;
	}
	public void setRutUsuario(int rutUsuario) {
		this.rutUsuario = rutUsuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdEstacionamiento() {
		return idEstacionamiento;
	}
	public void setIdEstacionamiento(int idEstacionamiento) {
		this.idEstacionamiento = idEstacionamiento;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
