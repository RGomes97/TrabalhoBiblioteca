package br.com.modelo;

public class Empregado {
	private int id;
	private String nome;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return "Código = "+getId()+ " | Nome = "+getNome()+ " | Idade = "+getAge();
	}
}