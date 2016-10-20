package com.oficina.saude.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Farmaceutico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message="CRF é obrigatório")
	private Integer crf;
	
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	
	@NotNull(message="CPF é obrigatório")
	private Integer cpf;
	
	@NotBlank(message="Endereço é obrigatório")
	private String endereco;
	
	@NotNull(message="Número da casa é obrigatório")
	private Integer numeroCasa;
	
	@NotBlank(message="Bairro é obrigatório")
	private String bairro;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de nascimento é obrigatório")
	private Date dataNascimento;
	
	
	public Integer getCrf() {
		return crf;
	}
	public void setCrf(Integer crf) {
		this.crf = crf;
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
