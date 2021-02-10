package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.UsuarioDAO;
import br.com.alura.horas.modelos.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {

	private Validator validator;

	private UsuarioDAO usuarioDAO;

	private Result result;

	public UsuarioController() {

	}

	@Inject
	public UsuarioController(Validator validator, UsuarioDAO usuarioDAO, Result result) {
		this.validator = validator;
		this.usuarioDAO = usuarioDAO;
		this.result = result;
	}

	public void form() {

	}

	@IncludeParameters
	public void adiciona(@Valid Usuario usuario) {
		this.validator.onErrorRedirectTo(this).form();

		this.usuarioDAO.adiciona(usuario);

		this.result.redirectTo(this).lista();
	}

	public void lista() {
		List<Usuario> lista = this.usuarioDAO.lista();
		
		this.result.include("usuarios", lista);
	}

}
