package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ingreso database table.
 * 
 */
@Embeddable
public class IngresoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="USUARIO_RUT", insertable=false, updatable=false)
	private int usuarioRut;

	public IngresoPK() {
		
	}
	
	public IngresoPK(int id, int usuarioRut) {
		this.id = id;
		this.usuarioRut = usuarioRut;
	}
	
	public IngresoPK(long usuarioRut) {
		this.usuarioRut = (int)usuarioRut;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuarioRut() {
		return this.usuarioRut;
	}
	public void setUsuarioRut(int usuarioRut) {
		this.usuarioRut = usuarioRut;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IngresoPK)) {
			return false;
		}
		IngresoPK castOther = (IngresoPK)other;
		return 
			(this.id == castOther.id)
			&& (this.usuarioRut == castOther.usuarioRut);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.usuarioRut;
		
		return hash;
	}
}