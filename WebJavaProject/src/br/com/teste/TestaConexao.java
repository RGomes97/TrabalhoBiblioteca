package br.com.teste;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;

public class TestaConexao {
	public static void main (String args[]) throws SQLException{
		Connection conexao = null;
		String url = "jdbc:mysql://localhost:3306/crudLp3";
		String usuario = "root"; 
		String senha = "1982cleber";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão efetuada com sucesso!!!");
		}catch(ClassNotFoundException cnfe){
			System.out.println("Erro ao carregar o driver"); 
			cnfe.printStackTrace();
		}
	}
}
