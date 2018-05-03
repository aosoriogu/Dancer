package mbController;

import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import entidad.Perfil;
import entidad.Usuario;
import service.PerfilService;
import service.UsuarioService;
import StringMB.StringMB;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {

		private static final long serialVersionUID = 8L;
		// Spring Usuario Service is injected...
		@ManagedProperty(value = "#{UsuarioService}")	
		UsuarioService usuarioService;

		@ManagedProperty(value = "#{PerfilService}")
		PerfilService perfilService;
		List<Usuario> usuarioList;
		private Integer id;
		public String getDireccionUsuario() {
			return direccionUsuario;
		}

		public void setDireccionUsuario(String direccionUsuario) {
			this.direccionUsuario = direccionUsuario;
		}

		private Integer idPerfil;
		private String nombreUsuario;
		private String apellidoUsuario;
		private long cedula;
		private int edadUsuario;
		private String telefonoUsuario;
		private String direccionUsuario;
		private String emailUsuario;
		private Timestamp fechaRegistro;
		private String username;
		private String contrasenaUsuario;
		private Usuario usuarioExistente;
		private Perfil perfil;
		
		
		
		private Date currentDate = new Date(); 


		public Date getCurrentDate() {
			return currentDate;
		}

		public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}

		public Integer getIdPerfil() {
			return idPerfil;
		}

		public void setIdPerfil(Integer idPerfil) {
			this.idPerfil = idPerfil;
		}

		public PerfilService getPerfilService() {
			return perfilService;
		}

		public void setPerfilService(PerfilService perfilService) {
			this.perfilService = perfilService;
		}

		public Usuario getUsuarioExistente() {
			return usuarioExistente;
		}

		public void setUsuarioExistente(Usuario usuarioExistente) {
			this.usuarioExistente = usuarioExistente;
		}

		public UsuarioService getUsuarioService() {
			return usuarioService;
		}

		public void setUsuarioService(UsuarioService usuarioService) {
			this.usuarioService = usuarioService;
		}

		public List<Usuario> getUsuarioList() {
			return usuarioList;
		}

		public void setUsuarioList(List<Usuario> usuarioList) {
			this.usuarioList = usuarioList;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getApellido() {
			return apellidoUsuario;
		}

		public void setApellido(String apellido) {
			this.apellidoUsuario = apellido;
		}

		public long getCedula() {
			return cedula;
		}

		public void setCedula(long cedula) {
			this.cedula = cedula;
		}
		
		public int getEdadUsuario() {
			return edadUsuario;
		}

		public void setEdadUsuario(int edadUsuario) {
			this.edadUsuario = edadUsuario;
		}

		public String getTelefonoUsuario() {
			return telefonoUsuario;
		}

		public void setTelefonoUsuario(String telefonoUsuario) {
			this.telefonoUsuario = telefonoUsuario;
		}
		
		public String getEmailUsuario() {
			return emailUsuario;
		}

		public void setEmailUsuario(String emailUsuario) {
			this.emailUsuario = emailUsuario;
		}

		public String getClave() {
			return contrasenaUsuario;
		}

		public void setClave(String clave) {
			this.contrasenaUsuario = clave;
		}

		public String getEmail() {
			return emailUsuario;
		}

		public void setEmail(String email) {
			this.emailUsuario = email;
		}


		public Timestamp getFechaRegistro() {
			return fechaRegistro;
		}

		public void setFechaRegistro(Timestamp fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}

		public String getNombre() {
			return nombreUsuario;
		}

		public void setNombre(String nombre) {
			this.nombreUsuario = nombre;
		}

		public String getUsuario() {
			return username;
		}

		public void setUsuario(String usuario) {
			this.username = usuario;
		}

		public List<Usuario> getUsuariosList() {
			usuarioList = new ArrayList<Usuario>();
			usuarioList.addAll(getUsuarioService().getUsuarios());
			return usuarioList;
		}



	
	
	public void agregarUsuario(){
		try{
			FacesMessage message = null;
			boolean documento = false;
			List<Usuario> pers = usuarioService.getUsuarios();
			for (Usuario per : pers) {
				if (per.getIdUsuario()==(cedula) || per.getNombreUsuario().equals(username)) {
					documento = true;
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "La cedula o usuario Ya existen  "+" ya existe ", ""));
					reset();
				}
			}
			if (!documento) {

				Usuario usuarios = new Usuario();
				usuarios.setNombreUsuario(username);
				usuarios.setContrasenaUsuario(StringMB.getStringMessageDigest(contrasenaUsuario, StringMB.MD5));
				usuarios.setIdUsuario(cedula);
				usuarios.setNombreUsuario(nombreUsuario);
				usuarios.setApellidoUsuario(apellidoUsuario);
				usuarios.setEmailUsuario(emailUsuario);

				java.util.Date utilDate = new java.util.Date();
				long lnMilisegundos = utilDate.getTime();
				java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);

				//usuarios.setFechaRegistro(sqlTimestamp);
				//usuarios.setIdPerfil(idPerfil);
				getUsuarioService().addUsuario(usuarios);


				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario, Registro agregado exitosamente.", "Registro agregado exitosamente.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}catch (DataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void reset() {

		this.setNombre(null);
		this.setApellido(null);
		this.setCedula((Long) null);
		this.setEmail(null);
		this.setClave(null);
		this.setUsuario(null);
		this.setIdPerfil(null);

	}
	
}
