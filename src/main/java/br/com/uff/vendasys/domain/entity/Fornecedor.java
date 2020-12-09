package br.com.uff.vendasys.domain.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @CNPJ
    private String cnpj;
    private String razaoSocial;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Fornecedor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
