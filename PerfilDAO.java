package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entidad.Perfil;



@Repository
public class PerfilDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addPerfil(Perfil perfil)
	{
		getSessionFactory().getCurrentSession().save(perfil);
	}
	
	public void deletePerfil(Perfil perfil)
	{
		getSessionFactory().getCurrentSession().delete(perfil);
	}
	
	public void updatePerfil(Perfil perfil)
	{
		getSessionFactory().getCurrentSession().update(perfil);
	}
	
	public List getPerfiles()
	{
		return getSessionFactory().getCurrentSession().createQuery("from Perfil").list();
	}
}
