package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reporte database table.
 * 
 */
@Entity
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nombre;

	@Column(name="XML_DATOS")
	private String xmlDatos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Reporte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getXmlDatos() {
		return this.xmlDatos;
	}

	public void setXmlDatos(String xmlDatos) {
		this.xmlDatos = xmlDatos;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}