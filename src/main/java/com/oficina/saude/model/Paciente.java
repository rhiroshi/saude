package com.oficina.saude.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@NotNull(message="CPF obrigatório")
	private Long cpf;
	
	@NotNull(message="RG obrigatório")
	private Long rg;
	
	@NotNull(message="CNS obrigatório")
	private Long cns;
	
	@NotBlank(message="Nome obrigatório")
	private String nome;
	
	@NotBlank(message="Endereço obrigatório")
	private String endereco;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de nascimento é obrigatório")
	private Date dataNascimento;	

	@NotNull(message="Número da residencia obrigatório")
	@Column(name="numero_casa")
	private Integer numeroCasa;
	
	@NotBlank(message="Bairro obrigatório")
	private String Bairro;
	
	@NotBlank(message="Telefone residêncial obrigatório")
	@Column(name="telefone_residencial")
	private String telefoneResidencial;
	
	@Column(name="telefone_celular")
	private String telefoneCelular;
	
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getRg() {
		return rg;
	}
	public void setRg(Long rg) {
		this.rg = rg;
	}
	public Long getCns() {
		return cns;
	}
	public void setCns(Long cns) {
		this.cns = cns;
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
	public Integer getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(Integer numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
