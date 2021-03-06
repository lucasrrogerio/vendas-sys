package br.com.uff.vendasys.web.dto;

import br.com.uff.vendasys.domain.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {
    public Long id;
    @Email
    public String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String senha;
    public String nome;
    @JsonProperty("tipoUsuario")
    public TipoUsuario tipoUsuarioEnum;
    @JsonIgnore
    private String tipoUsuario;

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuarioEnum() {
        return tipoUsuarioEnum;
    }

    public void setTipoUsuarioEnum(TipoUsuario tipoUsuarioEnum) {
        this.tipoUsuarioEnum = tipoUsuarioEnum;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
