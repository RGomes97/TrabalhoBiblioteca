package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.impacta.modelo.Permissao;
import br.com.impacta.modelo.Tipo_Usuario;
import br.com.impacta.modelo.Usuario;

public class UsuarioDAO {
	
	public static int grava(Usuario usuario) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "INSERT INTO usuarios(nome, email, tipo_usuario_id, senha, ra, permissao_id) VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setInt(3, usuario.getTipo().getId());
			pst.setString(4, usuario.getSenha());
			pst.setString(5, usuario.getRa());
			pst.setInt(3, usuario.getPermissao().getId());
			ret = pst.executeUpdate();
			System.out.println(usuario);
		} catch (SQLException sqle) {
			System.out.println("Não foi possível inserir os dados!!");
			System.out.println(sqle);
		}
		return ret;
	}
	
	public static int altera(Usuario usuario) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "UPDATE usuarios SET nome = ?, email = ?, "
				+ "tipo_usuario_id = ?, ra = ?, permissao_id = ? WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setInt(3, usuario.getTipo().getId());
			pst.setString(4, usuario.getRa());
			pst.setInt(5, usuario.getPermissao().getId());
			pst.setInt(6, usuario.getId());
			ret = pst.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Não foi possível atualizar os dados!!");
			System.out.println(sqle);
			sqle.printStackTrace();
		}
		return ret;
	}
	
	public static int exclui(int id) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
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
		PreparedStatement pst = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			String sql = "SELECT * FROM usuarios WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
				
				Tipo_Usuario tipo = escolheTipoUsuario(rs.getInt("tipo_usuario_id"));
				Permissao permissao = permissaoUsuario(rs.getInt("permissao_id"));
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTipo(tipo);
				usuario.setPermissao(permissao);
				usuario.setRa(rs.getString("ra"));
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
	
	
	private static Permissao permissaoUsuario(int id) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Permissao permissao = null;
		try {
			String sql = "SELECT * FROM permissoes where id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
					
				permissao = new Permissao(rs.getInt("id"),rs.getString("nome"));
	
			}
			System.out.println("Tipo "+permissao+" escolhido com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível escolher o tipo!!");
			sqle.printStackTrace();
		}
		return permissao;
	}

	public static List<Usuario> listaUsuarios() {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List <Usuario> usuarios = new ArrayList();

		try {
			String sql = "SELECT * FROM usuarios";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				do {
					Permissao permissao = permissaoUsuario(rs.getInt("permissao_id"));
					Tipo_Usuario tipo = escolheTipoUsuario(rs.getInt("tipo_usuario_id"));	
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTipo(tipo);
					usuario.setPermissao(permissao);
					usuario.setRa(rs.getString("ra"));
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
		if(usuarios.isEmpty()){
			System.out.println("Passei aqui");
		}
		return usuarios;
	}
	
	public static List<Permissao> listaPermissoes() {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List <Permissao> permissoes = new ArrayList();
		try {
			String sql = "SELECT * FROM permissoes";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				do {
					
					Permissao permissao = new Permissao(
							rs.getInt("id"),rs.getString("nome"));

					permissoes.add(permissao);
				} while(rs.next());	
			}
		} catch (SQLException sqle) {
			System.out.println("Não foi possível listar os tipos de usuarios!!");
			sqle.printStackTrace();
		}
		return permissoes;
	}
	

	public static List<Tipo_Usuario> listaTipos() {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
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
		PreparedStatement pst = null;
		ResultSet rs = null;
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
		PreparedStatement pst = null;
		ResultSet rs = null;
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