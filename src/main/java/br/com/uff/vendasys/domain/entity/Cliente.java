package br.com.uff.vendasys.domain.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;
    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;
    private String nome;
    @Email
    @Column(unique = true)
    private String email;
    private Integer pontos;
    @NotNull
    private boolean vip;
    @ManyToOne
    private Endereco endereco;
    @OneToMany
    private List<Reclamacao> reclamacoes;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Reclamacao> getReclamacoes() {
        return reclamacoes;
    }

    public void setReclamacoes(List<Reclamacao> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    public List<Reclamacao> addReclamacao(Reclamacao reclamacao) {
        this.reclamacoes.add(reclamacao);
        return this.reclamacoes;
    }

    public List<Reclamacao> removerReclamacao(Reclamacao reclamacao) {
        this.reclamacoes.remove(reclamacao);
        return this.reclamacoes;
    }
}
