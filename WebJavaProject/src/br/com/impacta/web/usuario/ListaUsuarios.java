package br.com.impacta.web.usuario;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.controller.Tarefa;
import br.com.impacta.dao.UsuarioDAO;
import br.com.impacta.modelo.Usuario;

public class ListaUsuarios implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		List<Usuario> usuarios = UsuarioDAO.listaUsuarios();
		if(!usuarios.isEmpty()){
			req.setAttribute("usuarios", usuarios);
		}		
		
		return "/frontend/views/usuario/listaUsuarios.jsp";
	}

}
