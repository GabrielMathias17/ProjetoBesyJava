package br.com.besyproject.model;

public class Empresa 
{
	// Atributos
	
	private int 	id;
	private String 	nome;
	private String 	endereco;
	private long 	cnpj;
	private long 	telefone;
	private String 	especialidade;
	
	// Construtores
	
	public Empresa() 
	{
		super();
	}
	
	public Empresa(int id, String nome, String endereco, long cnpj, long telefone, String especialidade) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}	

	// Métodos de Acesso
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
	// Métodos Gerais
	@Override
	public String toString() {
		return "Empresa [Id = " + id 
				+ ", Nome = " + nome 
				+ ", Endereco = " + endereco 
				+ ", Cnpj = " + cnpj 
				+ ", Telefone = " + telefone 
				+ ", Especialidade = " + especialidade + "]";
	}
}
