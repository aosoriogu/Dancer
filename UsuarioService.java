package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDAO;
import entidad.Usuario;


@Service("UsuarioService")
@Transactional(readOnly = true)
public class UsuarioService {
	// UsuarioDAO is injected...
	@Autowired
	UsuarioDAO usuarioDAO;
	

	@Transactional(readOnly = false)
	public void deleteUsuario(Usuario usuario) 
	{
		getUsuarioDAO().deleteUsuario(usuario);
	}

	@Transactional(readOnly = false)
	public void addUsuario(Usuario usuario) {
		getUsuarioDAO().addUsuario(usuario);
	}
	
	@Transactional(readOnly = false)
	public void updateUsuario(Usuario usuario) 
	{
		getUsuarioDAO().updateUsuario(usuario);
	}

	public Usuario getUsuarioById(Integer idUsuario) {
		return getUsuarioDAO().getUsuarioById(idUsuario);
	}

	public List<Usuario> getUsuarios() {
		return getUsuarioDAO().getUsuarios();
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	

	
}

