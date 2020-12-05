package br.com.uff.vendasys.domain.entity;

import br.com.uff.vendasys.domain.enums.TipoUsuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @NotBlank
    @Column(unique = true)
    private String username;
    private String nome;
    @Column(unique=true)
    private String email;
    private String senha;
    @NotNull
    private String tipoUsuario;
    @Transient
    private TipoUsuario tipoUsuarioEnum;
    private boolean ativo;
    private boolean tokenExpired;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public TipoUsuario getTipoUsuarioEnum() {
        return tipoUsuarioEnum;
    }

    public void setTipoUsuarioEnum(TipoUsuario tipoUsuarioEnum) {
        this.tipoUsuario = tipoUsuarioEnum.name();
        this.tipoUsuarioEnum = tipoUsuarioEnum;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
