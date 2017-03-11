package br.com.persistencia;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;


public class GerenteConexao {
	//metodo estático gerador de conexões 
	public static Connection getConexao(){
	Connection conexao = null;
	String url = "jdbc:mysql://localhost:3306/trabalhoBiblioteca";
	String usuario = "root";
	String senha = "1982cleber";
	try{
		Class.forName("org.gjt.mm.mysql.Driver");
		conexao = DriverManager.getConnection(url, usuario, senha);
		System.out.println("Conexão efetuada viado com sucesso!!!");
	}catch(ClassNotFoundException cnfe){
		System.out.println("Erro ao carregar o driver");
		cnfe.printStackTrace();
	}
	catch(SQLException sqle){
		System.out.println("Não foi possível conectar com o BD");
		sqle.printStackTrace();
	}
	return conexao;
	}
}