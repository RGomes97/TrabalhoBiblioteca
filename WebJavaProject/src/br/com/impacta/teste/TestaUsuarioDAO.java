package br.com.impacta.teste;

import java.util.List;

import br.com.impacta.dao.UsuarioDAO;
import br.com.impacta.modelo.Tipo_Usuario;
import br.com.impacta.modelo.Usuario;

public class TestaUsuarioDAO {
	public static void main(String args[]){
		
		// lista tipos de usuarios
		//UsuarioDAO.listaTipos();
		
		
		// recebe um tipo de usuario conforme o id passado
		// Tipo_Usuario tipo = UsuarioDAO.escolheTipoUsuario(2);
		
		
		// testa inserção de usuário
		/*Usuario usuario = new Usuario();
		usuario.setNome("William Tiririca Suguyama");
		usuario.setEmail("tiririca@tiririca.com");
		usuario.setTipo(tipo);
		usuario.setSenha("tiririca");
		UsuarioDAO.grava(usuario);*/
		
		
		// testa alteração
		/*Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Cleber Antonio Fernandes");
		usuario.setEmail("cle@cle.com");
		usuario.setTipo(tipo);
		usuario.setSenha("cleber");
		UsuarioDAO.altera(usuario);*/
		
		
		// testa exclusão	
		//usuarioDAO.exclui(1);
		
		
		// lista usuarios
		UsuarioDAO.listaUsuarios();
		
		// le um único usuario
		//UsuarioDAO.le(3);
	}
}