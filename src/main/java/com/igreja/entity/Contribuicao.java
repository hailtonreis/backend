package com.igreja.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_contribuicao")
public class Contribuicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contribuicao_id")
	private Long contribuicaoId;
	
	@CreationTimestamp
	@JsonFormat(pattern="dd-MM-yyyy:HH:mm")
	@Column(name = "data_criacao", updatable = false)
	private LocalDateTime dataCriacao;
	
	@UpdateTimestamp
	@JsonFormat(pattern="dd-MM-yyyy:HH:mm")
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name = "data_referencia")
	private LocalDate dataReferencia;

	 @NotNull(message = "O tipo de contribuição é obrigatório.")
	 @Column(name = "tipo_contribuicao", nullable = false, length = 50)
	 private String tipoContribuicao;
	
	 @NotNull(message = "O forma da contribuição é obrigatório.")
	 @Column(name = "forma_contribuicao")
	 private String formaContribuicao;
	
	 @NotNull(message = "O valor da contribuição é obrigatório.")
	 @Column(name = "valor", precision = 10, scale = 0)
	 private BigDecimal valor;
	
	 @Size(max = 255)
	 @Column(name = "descricao")
	 private String descricao;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "membro_id")
	 private Membro membro;
	 
	 public Contribuicao() {}
	 
	 public Contribuicao(Long contribuicaoId, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, LocalDate dataReferencia, String tipoContribuicao, String formaContribuicao, BigDecimal valor, String descricao, Membro membro) {
	    	this.contribuicaoId = contribuicaoId;
	    	this.dataCriacao = dataCriacao;
	    	this.dataAtualizacao = dataAtualizacao;
	    	this.dataReferencia = dataReferencia;
	    	this.tipoContribuicao = tipoContribuicao;
	    	this.formaContribuicao = formaContribuicao;
	    	this.valor = valor;
	    	this.descricao = descricao;
	    	this.membro = membro;
	    }

	public Long getContribuicaoId() {
		return contribuicaoId;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public LocalDate getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(LocalDate dataReferencia) {
		this.dataReferencia = dataReferencia;
	}	
	
	public String getTipoContribuicao() {
		return tipoContribuicao;
	}
	public void setTipoContribuicao(String tipoContribuicao) {
		this.tipoContribuicao = tipoContribuicao;
	}
	
	public String getFormaContribuicao() {
		return formaContribuicao;
	}
	public void setFormaContribuicao(String formaContribuicao) {
		this.formaContribuicao = formaContribuicao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Membro getMembro() {
		return membro;
	}
	public void setMembro(Membro membro) {
		this.membro = membro;
	}
}
