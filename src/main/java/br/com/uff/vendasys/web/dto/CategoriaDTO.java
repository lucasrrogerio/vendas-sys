package br.com.uff.vendasys.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CategoriaDTO {
    private Long id;
    private String codigo;
    private String nome;

    public CategoriaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
