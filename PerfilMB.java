package mbController;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import entidad.Perfil;
import service.PerfilService;


@ManagedBean(name = "PerfilMB")
@SessionScoped
public class PerfilMB implements Serializable 
{

	@ManagedProperty(value = "#{PerfilService}")
	PerfilService perfilService;
	
	public PerfilService getPerfilService() {
		return perfilService;
	}
	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}
	public void addPerfil() 
	{
		Perfil perfilNuevo = new Perfil();
		perfilNuevo.setCodPerfil(5);
		perfilNuevo.setNomPerfil("Prueba");
		getPerfilService().addPerfil(perfilNuevo);
	}

	public void deletePerfil(Perfil perfil) {
		getPerfilService().deletePerfil(perfil);
	}

	public void updatePerfil(Perfil perfil) {
		getPerfilService().updatePerfil(perfil);
	}
	public List getPerfiles() 
	{
		return getPerfilService().getPerfiles();
	} 
}
