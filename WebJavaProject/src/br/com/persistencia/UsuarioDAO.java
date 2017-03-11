package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.Usuario;
import br.com.modelo.Tipo_Usuario;

public class UsuarioDAO {
	
	public static int grava(Usuario usuario) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "INSERT INTO usuarios(nome, email, tipo_usuario_id, senha) VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setInt(3, usuario.getTipo().getId());
			pst.setString(4, usuario.getSenha());
			ret = pst.executeUpdate();
			System.out.println("Dados inseridos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível inserir os dados!!");
		}
		return ret;
	}
	
	public static int altera(Usuario usuario) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "UPDATE usuarios SET nome = ?, email = ?, "
				+ "tipo_usuario_id = ?, senha = ? WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setInt(3, usuario.getTipo().getId());
			pst.setString(4, usuario.getSenha());
			ret = pst.executeUpdate();
			System.out.println("Dados atualizados com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível atualizar os dados!!");
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
	
	public static Usuario lista() {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null, tipoq = null;
		Usuario usuario = null;
		Tipo_Usuario tipo = null;
		try {
			String sql = "SELECT * FROM usuarios";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				while(rs.next()){
					sql = "SELECT * FROM tipo_usuarios WHERE id = ?";
					pst = con.prepareStatement(sql);
					pst.setInt(1, rs.getInt("tipo_usuario_id"));
					tipoq = pst.executeQuery();
					
					tipo = new Tipo_Usuario();
					tipo.setId(tipoq.getInt("id"));
					tipo.setNome(tipoq.getString("nome"));
					
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTipo(tipo);
					System.out.println(usuario);
				}	
			}
			System.out.println("Dados Listados com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível listar os dados!!");
			sqle.printStackTrace();
		}
		return usuario;
	}
	
	public static Usuario le(int id) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null, tipoq = null;
		Usuario usuario = null;
		Tipo_Usuario tipo = null;
		try {
			String sql = "SELECT * FROM usuarios WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
				sql = "SELECT * FROM tipo_usuarios WHERE id = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, rs.getInt("tipo_usuario_id"));
				tipoq = pst.executeQuery();
				
				tipo = new Tipo_Usuario();
				tipo.setId(tipoq.getInt("id"));
				tipo.setNome(tipoq.getString("nome"));
				
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
		}
		return usuario;
	}
	
	/*public static List<Usuario> leTodos() {
		List <Usuario> usuarios = new ArrayList();
		Connection con = GerenteConexao.getConexao();
		Statement st = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM EMPREGADO;");
			while (rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setAge(rs.getInt("idade"));
				usuarios.add(usuario);
			}
			System.out.println("Dados lidos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível ler os dados!!");
			sqle.printStackTrace();
		}
		return usuarios;
	}*/
}
