package entidad;
// Generated 22/04/2018 07:09:53 PM by Hibernate Tools 5.2.8.Final

import java.net.InetAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;


/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {


	private int codUsuario;
	private Perfil perfil;
	private String nombreUsuario;
	private String apellidoUsuario;
	private int edadUsuario;
	private String userUsuario;
	private String contrasenaUsuario;
	private String emailUsuario;
	private long idUsuario;
	private String telefonoUsuario;
	private String direccionUsuario;
	private Set<Estudiante> estudiantes = new HashSet<Estudiante>(0);
	private Set<Empleado> empleados = new HashSet<Empleado>(0);
	private Set<Profesor> profesors = new HashSet<Profesor>(0);
	private Set<Administrador> administradors = new HashSet<Administrador>(0);

	public Usuario() {
	}

	public Usuario(int codUsuario, String nombreUsuario, String apellidoUsuario, int edadUsuario, String userUsuario,
			String contrasenaUsuario, String emailUsuario, long idUsuario, String telefonoUsuario,
			String direccionUsuario) {
		this.codUsuario = codUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.edadUsuario = edadUsuario;
		this.userUsuario = userUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
		this.emailUsuario = emailUsuario;
		this.idUsuario = idUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.direccionUsuario = direccionUsuario;
	}

	public Usuario(int codUsuario, Perfil perfil, String nombreUsuario, String apellidoUsuario, int edadUsuario,
			String userUsuario, String contrasenaUsuario, String emailUsuario, long idUsuario, String telefonoUsuario,
			String direccionUsuario, Set<Estudiante> estudiantes, Set<Empleado> empleados, Set<Profesor> profesors,
			Set<Administrador> administradors) {
		this.codUsuario = codUsuario;
		this.perfil = perfil;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.edadUsuario = edadUsuario;
		this.userUsuario = userUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
		this.emailUsuario = emailUsuario;
		this.idUsuario = idUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.direccionUsuario = direccionUsuario;
		this.estudiantes = estudiantes;
		this.empleados = empleados;
		this.profesors = profesors;
		this.administradors = administradors;
	}

	@Id

	@Column(name = "cod_usuario", unique = true, nullable = false)
	public int getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_perfil")
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Column(name = "nombre_usuario", nullable = false)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "apellido_usuario", nullable = false)
	public String getApellidoUsuario() {
		return this.apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	@Column(name = "edad_usuario", nullable = false)
	public int getEdadUsuario() {
		return this.edadUsuario;
	}

	public void setEdadUsuario(int edadUsuario) {
		this.edadUsuario = edadUsuario;
	}

	@Column(name = "user_usuario", nullable = false)
	public String getUserUsuario() {
		return this.userUsuario;
	}

	public void setUserUsuario(String userUsuario) {
		this.userUsuario = userUsuario;
	}

	@Column(name = "contrasena_usuario", nullable = false)
	public String getContrasenaUsuario() {
		return this.contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	@Column(name = "email_usuario", nullable = false)
	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Column(name = "id_usuario", nullable = false)
	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "telefono_usuario", nullable = false)
	public String getTelefonoUsuario() {
		return this.telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	@Column(name = "direccion_usuario", nullable = false)
	public String getDireccionUsuario() {
		return this.direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(Set<Administrador> administradors) {
		this.administradors = administradors;
	}
	
	
	
}
