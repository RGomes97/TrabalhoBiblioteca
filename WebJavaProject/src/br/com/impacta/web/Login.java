package br.com.impacta.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.impacta.dao.UsuarioDAO;
import br.com.impacta.modelo.Usuario;


public class Login implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().login(email, senha);
		if(usuario==null){
			
			return "/frontend/views/admin.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("logadoComo", usuario);
			return "/frontend/views/admin.jsp";
		}
	}
}
