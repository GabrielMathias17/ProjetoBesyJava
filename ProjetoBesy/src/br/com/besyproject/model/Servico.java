package br.com.besyproject.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Servico 
{
	private int 		id;
	private int 		idEmpresa;
	private int 		idCliente;
	private String 		descricao;
	private BigDecimal 	valor;
	private LocalDate 	dataServico;
	
	// Construtores
	
	public Servico() 
	{
		super();
	}
	
	public Servico(int id, int idEmpresa, int idCliente, String descricao, BigDecimal valor, LocalDate dataServico) 
	{
		super();
		this.id = id;
		this.idEmpresa = idEmpresa;
		this.idCliente = idCliente;
		this.descricao = descricao;
		this.valor = valor;
		this.dataServico = dataServico;
	}

	// Métodos de Acesso
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDataServico() {
		return dataServico;
	}
	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}

	// Métodos Gerais
	
	@Override
	public String toString() {
		return "Servico [Id = " + id 
				+ ", Id da Empresa = " + idEmpresa 
				+ ", Id do Cliente = " + idCliente 
				+ ", Descricao = " + descricao 
				+ ", Valor = " + valor 
				+ ", Data do Serviço = " + dataServico + "]";
	}	
}
