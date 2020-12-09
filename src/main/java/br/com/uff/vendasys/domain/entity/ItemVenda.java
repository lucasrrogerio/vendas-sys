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
    private Double precoVenda;
    private Double precoPromocao;
    private boolean isPromocao;

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

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoPromocao() {
        return precoPromocao;
    }

    public void setPrecoPromocao(Double precoPromocao) {
        this.precoPromocao = precoPromocao;
    }

    public boolean isPromocao() {
        return isPromocao;
    }

    public void setPromocao(boolean promocao) {
        isPromocao = promocao;
    }
}
