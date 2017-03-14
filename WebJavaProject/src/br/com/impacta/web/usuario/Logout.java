package br.com.impacta.web.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.impacta.controller.Tarefa;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.removeAttribute("logadoComo"); // remove o o atributo da sessao
		// req.getSession().invalidate(); elimina tudo da sessao
		session.setMaxInactiveInterval(600);
		// redireciona para html
		return "/WEB-INF/paginas/logout.html";
		
	}

}
