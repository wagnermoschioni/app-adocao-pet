package br.com.adocao.model;

import java.util.Date;

public class Pet {

	private Integer id;
	private String nome;
	private String raca;
	private Date dataNascimento;
	private boolean vacinado = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
		
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}
	
	public boolean vacinado() {
		return vacinado;
	}
	
	
}
