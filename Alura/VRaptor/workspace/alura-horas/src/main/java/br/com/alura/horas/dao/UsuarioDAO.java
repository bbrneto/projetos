package br.com.alura.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDAO {
	
	private EntityManager manager;
	
	public UsuarioDAO() {
		
	}

	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Usuario usuario) {
		this.manager.getTransaction().begin();
		
		this.manager.persist(usuario);
		
		this.manager.getTransaction().commit();
	}
	
	public List<Usuario> lista() {
		TypedQuery<Usuario> query = this.manager.createQuery("select u from Usuario u", Usuario.class);
		
		return query.getResultList();
	}

}
