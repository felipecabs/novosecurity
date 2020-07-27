package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the estacionamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Estacionamiento.findAll", query="SELECT e FROM Estacionamiento e")
public class Estacionamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstacionamientoPK id;

	private String estado;

	private String piso;

	private String tipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(optional = false)
	@JoinColumn(name="USUARIO_RUT", referencedColumnName="rut", insertable = false, updatable = false)
	@JsonIgnore
	private Usuario usuario;

	public Estacionamiento() {
	}

	public EstacionamientoPK getId() {
		return this.id;
	}

	public void setId(EstacionamientoPK id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPiso() {
		return this.piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}