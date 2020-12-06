package br.com.uff.vendasys.domain.entity;

import br.com.uff.vendasys.domain.enums.StatusVenda;
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
    @OneToMany
    private List<ItemVenda> itens;
    @OneToOne
    private Pagamento pagamento;
    private StatusVenda statusVenda;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public StatusVenda getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(StatusVenda statusVenda) {
        this.statusVenda = statusVenda;
    }
}
