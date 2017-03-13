package br.com.impacta.modelo;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private Tipo_Usuario tipo;
	private String senha;
	
	public Usuario(){
		
	}
	
	public Usuario(int id, String nome, String email, Tipo_Usuario tipo,
			String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
		this.senha = senha;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Tipo_Usuario getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Usuario tipo) {
		this.tipo = tipo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "nome: "+this.nome+"\nemail: "+this.email+"\ntipo: "+this.tipo.getNome();
	}
	
	
	
}
