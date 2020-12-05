package br.com.uff.vendasys.domain.entity;

import br.com.uff.vendasys.domain.enums.TipoPagamento;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private LocalDateTime data;
    @NotNull
    private Double total;
    @NotNull
    private boolean isVip;
    @ManyToOne
    @NotNull
    private Cliente cliente;
    private Integer pontosResgatados;
    @NotNull
    private TipoPagamento tipoPagamento;
    @OneToMany
    private List<ItemVenda> itens;

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public Integer getPontosResgatados() {
        return pontosResgatados;
    }

    public void setPontosResgatados(Integer pontosResgatados) {
        this.pontosResgatados = pontosResgatados;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public List<ItemVenda> addItem(ItemVenda item) {
        this.itens.add(item);
        return this.itens;
    }

    public List<ItemVenda> removeItem(ItemVenda item) {
        this.itens.remove(item);
        return this.itens;
    }
}
