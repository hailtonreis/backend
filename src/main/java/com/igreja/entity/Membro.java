package com.igreja.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_membro")
public class Membro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "membro_id")
	private Long membroId;
    
    @NotNull(message = "O nome é obrigatório.")
   // @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Column(name = "nome")
	private String nome;

    //@Pattern(regexp = "\\d{11}")
    @Column(name = "contato", length = 11)
    private String contato;
    
  //  @Size(min = 10, max = 100, message = "O e-mail tem tamanho maior que o permitido!")
    @Column(name = "email")
    private String email;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    //@NotNull(message = "O número do CPF é obrigatório.")
    //@Size(min = 11, max = 11, message = "O número do CPF deve ter de 2 a 11 caracteres.")
    //@Column(name = "cpf", nullable = false, length = 11)
    @Column(name = "cpf")
	private String cpf;
    
   // @Size(min = 10, max = 255)
    @Column(name = "endereco")
    private String endereco;
    
    
  //  @Size(min = 0, max = 255)
    @Column(name = "cidade")
    private String cidade;
    
    
    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;
    
    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
    
    public Membro() {}
    
    public Membro(Long membroId, String nome, String contato, String email, String cpf, String endereco, String cidade, LocalDate dataNascimento) {
    	this.membroId = membroId;
    	this.nome = nome; 
    	this.contato = contato; 
    	this.email = email; 
    	this.cpf = cpf; 
    	this.endereco = endereco;
    	this.cidade = cidade;
    	this.dataNascimento = dataNascimento;
    }
    
    public Long getMembroId() {
        return membroId;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public int getIdade() {
    	if(dataNascimento == null) return 0;
    	return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}
