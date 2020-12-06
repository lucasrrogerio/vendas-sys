package br.com.uff.vendasys.domain.entity;

import br.com.uff.vendasys.service.PagamentoStrategy;

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
    @OneToMany
    private List<ItemVenda> itens;
    @Transient
    public PagamentoStrategy pagamento;

    public Venda() {
    }

    public Venda(PagamentoStrategy pagamento) {
        this.pagamento = pagamento;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PagamentoStrategy getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoStrategy pagamento) {
        this.pagamento = pagamento;
    }
}
