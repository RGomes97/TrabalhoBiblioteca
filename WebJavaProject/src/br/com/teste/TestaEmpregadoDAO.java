package br.com.teste;

import br.com.modelo.Empregado;
import br.com.modelo.EmpregadoDAO;

public class TestaEmpregadoDAO {
	public static void main(String args[]){
		/*Empregado empregado = new Empregado();
		empregado.setNome("Luiz");
		empregado.setAge(45);
		EmpregadoDAO.grava(empregado);*/
		
		// testa alteração
		
		/*Empregado empregado = new Empregado();
		empregado.setId(2);
		empregado.setNome("Luiz");
		empregado.setAge(45);
		EmpregadoDAO.altera(empregado);*/
		
		// testa exclusão
		
		//EmpregadoDAO.exclui(1);
		
		// lista empregados
		
		EmpregadoDAO.lista();
		
		// le um único empregado
		
		//EmpregadoDAO.le(3);
	}
}