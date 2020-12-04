package br.com.uff.vendasys.web.dto;

public class CategoriaDTO {
    private String codigo;
    private String nome;

    public CategoriaDTO() {
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
