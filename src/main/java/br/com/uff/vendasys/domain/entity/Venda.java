package br.com.uff.vendasys.domain.entity;

import br.com.uff.vendasys.domain.enums.StatusVenda;

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
    private boolean pediuResgate;
    @ManyToOne
    @NotNull
    private Cliente cliente;
    private Integer pontosResgatados;
    @OneToMany
    private List<ItemVenda> itens;
    @OneToOne
    private Pagamento pagamento;
    @Transient
    public NotaFiscal notaFiscal;
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

    public boolean pediuResgate() {
        return pediuResgate;
    }

    public void setPediuResgate(boolean pediuResgate) {
        this.pediuResgate = pediuResgate;
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

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public StatusVenda getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(StatusVenda statusVenda) {
        this.statusVenda = statusVenda;
    }
}
