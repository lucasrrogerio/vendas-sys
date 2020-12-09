package br.com.uff.vendasys.web.dto;

public class ItemVendaDTO {
    private Long id;
    private ProdutoDTO produto;
    private Integer quantidade;
    private Double preco;
    private Double promocao;

    public ItemVendaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
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
