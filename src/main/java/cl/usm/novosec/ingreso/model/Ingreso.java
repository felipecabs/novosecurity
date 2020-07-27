package cl.usm.novosec.ingreso.model;

import java.util.Date;

public class Ingreso {
	private int id;
	private String estado;
	private Date fecha;
	private String tipo;
	private Integer estacionamientoVisita;
	private String comentarios;
	private Usuario usuario;
	
	public Ingreso() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEstacionamientoVisita() {
		return estacionamientoVisita;
	}

	public void setEstacionamientoVisita(Integer estacionamientoVisita) {
		this.estacionamientoVisita = (estacionamientoVisita == null) ? -1 : estacionamientoVisita;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
