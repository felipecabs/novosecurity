package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vehiculo database table.
 * 
 */
@Embeddable
public class VehiculoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String patente;

	@Column(name="USUARIO_RUT", insertable=false, updatable=false)
	private int usuarioRut;

	public VehiculoPK() {
	}
	public String getPatente() {
		return this.patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
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
		if (!(other instanceof VehiculoPK)) {
			return false;
		}
		VehiculoPK castOther = (VehiculoPK)other;
		return 
			this.patente.equals(castOther.patente)
			&& (this.usuarioRut == castOther.usuarioRut);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.patente.hashCode();
		hash = hash * prime + this.usuarioRut;
		
		return hash;
	}
}