package cl.usm.novosec.ingreso.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RUT")
	private int rut;

	private String departamento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	private String genero;

	private String mail;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Estacionamiento
	@OneToMany(mappedBy="usuario")
	private List<Estacionamiento> estacionamientos;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="usuario")
	private List<Ingreso> ingresos;

	//bi-directional many-to-one association to Invitacion
	@OneToMany(mappedBy="usuario1")
	private List<Invitacion> invitacions1;

	//bi-directional many-to-one association to Invitacion
	@OneToMany(mappedBy="usuario2")
	private List<Invitacion> invitacions2;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="usuario")
	private List<Reporte> reportes;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="`usuario-rol`"
		, joinColumns={
			@JoinColumn(name="USUARIO_RUT")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROL_ID")
			}
		)
	private List<Rol> rols;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="usuario")
	private List<Vehiculo> vehiculos;

	public Usuario() {
	}

	public int getRut() {
		return this.rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}

	public void setEstacionamientos(List<Estacionamiento> estacionamientos) {
		this.estacionamientos = estacionamientos;
	}

	public Estacionamiento addEstacionamiento(Estacionamiento estacionamiento) {
		getEstacionamientos().add(estacionamiento);
		estacionamiento.setUsuario(this);

		return estacionamiento;
	}

	public Estacionamiento removeEstacionamiento(Estacionamiento estacionamiento) {
		getEstacionamientos().remove(estacionamiento);
		estacionamiento.setUsuario(null);

		return estacionamiento;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setUsuario(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setUsuario(null);

		return ingreso;
	}

	public List<Invitacion> getInvitacions1() {
		return this.invitacions1;
	}

	public void setInvitacions1(List<Invitacion> invitacions1) {
		this.invitacions1 = invitacions1;
	}

	public Invitacion addInvitacions1(Invitacion invitacions1) {
		getInvitacions1().add(invitacions1);
		invitacions1.setUsuario1(this);

		return invitacions1;
	}

	public Invitacion removeInvitacions1(Invitacion invitacions1) {
		getInvitacions1().remove(invitacions1);
		invitacions1.setUsuario1(null);

		return invitacions1;
	}

	public List<Invitacion> getInvitacions2() {
		return this.invitacions2;
	}

	public void setInvitacions2(List<Invitacion> invitacions2) {
		this.invitacions2 = invitacions2;
	}

	public Invitacion addInvitacions2(Invitacion invitacions2) {
		getInvitacions2().add(invitacions2);
		invitacions2.setUsuario2(this);

		return invitacions2;
	}

	public Invitacion removeInvitacions2(Invitacion invitacions2) {
		getInvitacions2().remove(invitacions2);
		invitacions2.setUsuario2(null);

		return invitacions2;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setUsuario(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setUsuario(null);

		return reporte;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setUsuario(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setUsuario(null);

		return vehiculo;
	}

}