package br.com.besyproject.model;

import java.time.LocalDate;

public class Cliente 
{
	// Atributos
	
	private int 		id;
	private String 		nome;
	private LocalDate	dataNascimento;
	private long 		telefone;
	private long 		cpf;
	private String 		endereco;
	
	// Construtores
	
	public Cliente() 
	{
		super();
	}
	
	public Cliente(int id, String nome, LocalDate dataNascimento, long telefone, long cpf, String endereco) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	// Métodos de acesso
	
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	// Métodos Gerais
	
	@Override
	public String toString() {
		return "Cliente [Id = " + id 
				+ " , Nome = " + nome 
				+ ", Data de Nascimento = " + dataNascimento 
				+ ", Telefone = " + telefone
				+ ", Cpf = " + cpf 
				+ ", Endereco = " + endereco + "]";
	}
}
