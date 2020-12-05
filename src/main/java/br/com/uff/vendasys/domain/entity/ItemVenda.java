package br.com.uff.vendasys.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @NotNull
    private Produto produto;
    @NotNull
    private Integer quantidade;
    @NotNull
    private Double preco;
    @NotNull
    private Double promocao;

    public ItemVenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPromocao() {
        return promocao;
    }

    public void setPromocao(Double promocao) {
        this.promocao = promocao;
    }
}
