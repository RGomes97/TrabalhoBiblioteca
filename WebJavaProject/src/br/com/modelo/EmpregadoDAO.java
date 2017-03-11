package br.com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.persistencia.GerenteConexao;
import br.com.modelo.Empregado;

public class EmpregadoDAO {
	public static int grava(Empregado empregado) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "INSERT INTO empregados(nome, age) VALUES(?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, empregado.getNome());
			pst.setInt(2, empregado.getAge());
			ret = pst.executeUpdate();
			System.out.println("Dados inseridos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível inserir os dados!!");
		}
		return ret;
	}
	
	public static int altera(Empregado empregado) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "UPDATE empregados SET nome = ?, age = ? WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, empregado.getNome());
			pst.setInt(2, empregado.getAge());
			pst.setInt(3, empregado.getId());
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
			String sql = "DELETE FROM empregados WHERE id = ?";
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
	
	public static Empregado lista() {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Empregado empregado = null;
		try {
			String sql = "SELECT * FROM empregados";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				while(rs.next()){
					empregado = new Empregado();
					empregado.setId(rs.getInt("id"));
					empregado.setNome(rs.getString("nome"));
					empregado.setAge(rs.getInt("age"));
					System.out.println(empregado);
				}	
			}
			System.out.println("Dados Listados com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível listar os dados!!");
			sqle.printStackTrace();
		}
		return empregado;
	}
	
	public static Empregado le(int id) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Empregado empregado = null;
		try {
			String sql = "SELECT * FROM empregados WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
				empregado = new Empregado();
				empregado.setId(rs.getInt("id"));
				empregado.setNome(rs.getString("nome"));
				empregado.setAge(rs.getInt("age"));
				System.out.println(empregado);
			}
			System.out.println("Dados obtidos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível obter os dados!!");
			sqle.printStackTrace();
		}
		return empregado;
	}
	
	/*public static List<Empregado> leTodos() {
		List <Empregado> empregados = new ArrayList();
		Connection con = GerenteConexao.getConexao();
		Statement st = null;
		ResultSet rs = null;
		Empregado empregado = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM EMPREGADO;");
			while (rs.next()){
				empregado = new Empregado();
				empregado.setId(rs.getInt("codigo"));
				empregado.setNome(rs.getString("nome"));
				empregado.setAge(rs.getInt("idade"));
				empregados.add(empregado);
			}
			System.out.println("Dados lidos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível ler os dados!!");
			sqle.printStackTrace();
		}
		return empregados;
	}*/
}
