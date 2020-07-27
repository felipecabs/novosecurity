package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VehiculoPK id;

	private String anio;

	private String marca;

	private String modelo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(optional = false)
	@JoinColumn(name="USUARIO_RUT",referencedColumnName="rut", insertable = false, updatable = false)
	private Usuario usuario;

	public Vehiculo() {
	}

	public VehiculoPK getId() {
		return this.id;
	}

	public void setId(VehiculoPK id) {
		this.id = id;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}