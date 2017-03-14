package br.com.impacta.web.usuario;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.controller.Tarefa;
import br.com.impacta.dao.UsuarioDAO;
import br.com.impacta.modelo.Usuario;

public class BuscaUsuario implements Tarefa {
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
	
		String filtro = req.getParameter("filtro");	
		Collection<Usuario> empresas = new UsuarioDAO().buscaUsuario(filtro);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/Paginas/buscaEmpresa.jsp";
	}
}
