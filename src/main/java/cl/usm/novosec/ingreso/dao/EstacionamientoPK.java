package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the estacionamiento database table.
 * 
 */
@Embeddable
public class EstacionamientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int numero;

	@Column(name="USUARIO_RUT", insertable=false, updatable=false)
	private int usuarioRut;

	public EstacionamientoPK() {
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
		if (!(other instanceof EstacionamientoPK)) {
			return false;
		}
		EstacionamientoPK castOther = (EstacionamientoPK)other;
		return 
			(this.numero == castOther.numero)
			&& (this.usuarioRut == castOther.usuarioRut);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numero;
		hash = hash * prime + this.usuarioRut;
		
		return hash;
	}
}