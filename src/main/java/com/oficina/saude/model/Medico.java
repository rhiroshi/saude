package com.oficina.saude.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Medico {

	@Id
	private Integer crm;
	private String especialidade;
	@NotNull(message="Nome é obrigatório")
	private String nome;
	@NotNull(message="CPF é obrigatório")
	private Integer cpf;
	@NotNull(message="Endereço é obrigatório")
	private String endereco;
	@NotNull(message="Número da casa é obrigatório")
	private Integer numeroCasa;
	@NotNull(message="Bairro é obrigatório")
	private String bairro;
	@NotNull(message="Data de nascimento é obrigatório")
	private Date dataNascimento;
	public Integer getCrm() {
		return crm;
	}
	public void setCrm(Integer crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(Integer numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
	
	
	
	
	
}
