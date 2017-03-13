package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.impacta.modelo.Tipo_Usuario;
import br.com.impacta.modelo.Usuario;

public class UsuarioDAO {
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	public static int grava(Usuario usuario) {
		Connection con = GerenteConexao.getConexao();
		
		int ret = 0;
		try {
			String sql = "INSERT INTO usuarios(nome, email, tipo_usuario_id, senha) VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setInt(3, usuario.getTipo().getId());
			pst.setString(4, usuario.getSenha());
			ret = pst.executeUpdate();
			System.out.println(usuario);
			System.out.println("Dados inseridos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível inserir os dados!!");
			System.out.println(sqle);
		}
		return ret;
	}
	
	public static int altera(Usuario usuario) {
		Connection con = GerenteConexao.getConexao();
		int ret = 0;
		try {
			String sql = "UPDATE usuarios SET nome = ?, email = ?, "
				+ "tipo_usuario_id = ?, senha = ? WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setInt(3, usuario.getTipo().getId());
			pst.setString(4, usuario.getSenha());
			pst.setInt(5, usuario.getId());
			ret = pst.executeUpdate();
			System.out.println("Dados atualizados com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível atualizar os dados!!");
			System.out.println(sqle);
			sqle.printStackTrace();
		}
		return ret;
	}
	
	public static int exclui(int id) {
		Connection con = GerenteConexao.getConexao();
		int ret = 0; 
		try {
			String sql = "DELETE FROM usuarios WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ret = pst.executeUpdate();
			System.out.println("Dados excluído com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível excluir os dados!!");
			sqle.printStackTrace();
		}
		return ret;
	}

	
	public static Usuario le(int id) {
		Connection con = GerenteConexao.getConexao();
		
		Usuario usuario = null;
		Tipo_Usuario tipo = null;
		try {
			String sql = "SELECT * FROM usuarios WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
				
				tipo = escolheTipoUsuario(rs.getInt("tipo_usuario_id"));
				
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTipo(tipo);
				System.out.println(usuario);
			}
			System.out.println("Dados obtidos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível obter os dados!!");
			sqle.printStackTrace();
			System.out.println(sqle);
		}
		return usuario;
	}
	
	
	public static List<Usuario> listaUsuarios() {
		Connection con = GerenteConexao.getConexao();

		List <Usuario> usuarios = new ArrayList();
		Usuario usuario = null;
		Tipo_Usuario tipo = null;
		try {
			String sql = "SELECT * FROM usuarios";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				do {
					
					tipo = escolheTipoUsuario(rs.getInt("tipo_usuario_id"));	
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTipo(tipo);
					usuarios.add(usuario);
					System.out.println(usuario);
				} while(rs.next());
			}
			System.out.println("Dados Listados com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível listar os dados!!");
			System.out.println(sqle);
			sqle.printStackTrace();
		}
		return usuarios;
	}
	

	public static List<Tipo_Usuario> listaTipos() {
		Connection con = GerenteConexao.getConexao();

		List <Tipo_Usuario> tipos = new ArrayList();
		Tipo_Usuario tipo = null;
		try {
			String sql = "SELECT * FROM tipo_usuario";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				do {
					
					tipo = new Tipo_Usuario();
					tipo.setId(rs.getInt("id"));
					tipo.setNome(rs.getString("nome"));
					tipos.add(tipo);
					System.out.println(tipo);
				} while(rs.next());	
			}
		} catch (SQLException sqle) {
			System.out.println("Não foi possível listar os tipos de usuarios!!");
			sqle.printStackTrace();
		}
		return tipos;
	}
	
	public static Tipo_Usuario escolheTipoUsuario(int id) {
		Connection con = GerenteConexao.getConexao();

		Tipo_Usuario tipo = null;
		try {
			String sql = "SELECT * FROM tipo_usuario where id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
					
				tipo = new Tipo_Usuario();
				tipo.setId(rs.getInt("id"));
				tipo.setNome(rs.getString("nome"));	
			}
			System.out.println("Tipo "+tipo+" escolhido com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível escolher o tipo!!");
			sqle.printStackTrace();
		}
		return tipo;
	}

	public Usuario login(String email, String senha) {
		Connection con = GerenteConexao.getConexao();

		Map <String,Usuario> usuarios = new HashMap();
		
		try {
			String sql = "SELECT * FROM usuarios";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				do {
					
					Tipo_Usuario tipo = escolheTipoUsuario(rs.getInt("tipo_usuario_id"));	
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTipo(tipo);
					usuarios.put(usuario.getEmail(), usuario);
				} while(rs.next());
			}
		} catch (SQLException sqle) {
			System.out.println("Não foi possível listar os dados!!");
			sqle.printStackTrace();
		}
		
		if (!usuarios.containsKey(email))
			return null;

		Usuario usuario = usuarios.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

	public Collection<Usuario> buscaUsuario(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}