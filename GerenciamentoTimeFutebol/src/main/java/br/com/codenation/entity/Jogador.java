package br.com.codenation.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador{
	
	private Long idid;
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;
	

	public Long getIdTime() {
		return idTime;
	}
	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getNivelHabilidade() {
		return nivelHabilidade;
	}
	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Long getIdid() {
		return idid;
	}
	public void setIdid(Long idid) {
		this.idid = idid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
