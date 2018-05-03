package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.PerfilDAO;
import entidad.Perfil;

@Service("PerfilService")
@Transactional(readOnly = true)
public class PerfilService 
{
	@Autowired
	PerfilDAO perfilDAO;
	
	public PerfilDAO getPerfilDAO() {
		return perfilDAO;
	}

	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}
	
	@Transactional(readOnly = false)
	public void addPerfil(Perfil perfil) {
		getPerfilDAO().addPerfil(perfil);
	}

	@Transactional(readOnly = false)
	public void deletePerfil(Perfil perfil) {
		getPerfilDAO().deletePerfil(perfil);
	}

	@Transactional(readOnly = false)
	public void updatePerfil(Perfil perfil) {
		getPerfilDAO().updatePerfil(perfil);
	}
	
	public List getPerfiles() 
	{
		return getPerfilDAO().getPerfiles();
	}
}
