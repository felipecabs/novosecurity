package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


/**
 * The persistent class for the ingreso database table.
 * 
 */
@Entity
@NamedQuery(name="Ingreso.findAll", query="SELECT i FROM Ingreso i")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngresoPK id;

	private String estado;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA")
	private Date fecha;
	
	private String tipo;
	
	@Column(name="ESTACIONAMIENTO_VISITA")
	private Integer estacionamientoVisita;
	
	private String comentarios;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne(optional = false)
	@JoinColumn(name="USUARIO_RUT",referencedColumnName="rut", insertable = false, updatable = false)
	private Usuario usuario;

	public Ingreso() {
	}

	public IngresoPK getId() {
		return this.id;
	}

	public void setId(IngresoPK id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getEstacionamientoVisita() {
		return estacionamientoVisita;
	}

	public void setEstacionamientoVisita(Integer estacionamientoVisita) {
		this.estacionamientoVisita = estacionamientoVisita;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}