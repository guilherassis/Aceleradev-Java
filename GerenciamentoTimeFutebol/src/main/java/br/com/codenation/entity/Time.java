package br.com.codenation.entity;

import java.time.LocalDate;




public class Time {
	private Long idTime;
	private String nomeTime;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	private Long idJogadorCapitao;
	
	
	

	public Long getIdTime() {
		return idTime;
	}
	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}
	public void setCorUniformePrincipal(String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}
	public void setCorUniformeSecundario(String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}
	public Long getIdJogadorCapitao() {
		return idJogadorCapitao;
	}
	public void setIdJogadorCapitao(Long idJogadorCapitao) {
		this.idJogadorCapitao = idJogadorCapitao;
	}


}
