package br.com.uff.vendasys.web.dto;

import br.com.uff.vendasys.domain.entity.Cliente;
import br.com.uff.vendasys.domain.entity.ItemVenda;

import java.time.LocalDateTime;
import java.util.List;

public class VendaDTO {

    private Long id;
    private LocalDateTime data;
    private Double total;
    private boolean isVip;
    private Cliente cliente;
    private Integer pontosResgatados;
    private List<ItemVenda> itens;
    private PagamentoDTO pagamento;

    public VendaDTO() {
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

    public PagamentoDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }
}
