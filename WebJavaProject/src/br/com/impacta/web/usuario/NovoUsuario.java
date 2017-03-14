package br.com.impacta.web.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.controller.Tarefa;
import br.com.impacta.modelo.Usuario;

public class NovoUsuario implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Usuario usuario = new Usuario();
		req.setAttribute("usuario", usuario);
		return "/frontend/views/usuario/novoUsuario.jsp";
	}

}
