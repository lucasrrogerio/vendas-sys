package br.com.uff.vendasys.domain.entity;

import br.com.uff.vendasys.domain.enums.TipoUsuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @Column(unique=true)
    private String email;
    private String senha;
    @NotNull
    private String tipoUsuario;
    @Transient
    private TipoUsuario tipoUsuarioEnum;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuarioEnum() {
        return tipoUsuarioEnum;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuarioEnum(TipoUsuario tipoUsuarioEnum) {
        this.tipoUsuario = tipoUsuarioEnum.name();
        this.tipoUsuarioEnum = tipoUsuarioEnum;
    }
}
