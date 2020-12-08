package br.com.uff.vendasys.service.builder;

import br.com.uff.vendasys.domain.entity.ItemVenda;
import br.com.uff.vendasys.domain.entity.NotaFiscal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalBuilder {

    private String nome;
    private String cpf;
    private Double valorBruto;
    private Double impostos;
    private List<ItemVenda> itens = new ArrayList<>();
    private String observacoes;
    private LocalDateTime data;

    public NotaFiscalBuilder() {
    }

    public NotaFiscalBuilder paraCliente(String nome) {
        this.nome = nome;
        return this;
    }

    public NotaFiscalBuilder comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public NotaFiscalBuilder comItens(List<ItemVenda> itens) {
        this.itens = itens;
        return this;
    }

    public NotaFiscalBuilder com(ItemVenda item) {
        itens.add(item);
        valorBruto += item.getPrecoVenda();
        impostos += item.getPrecoVenda() * 0.05;
        return this;
    }

    public NotaFiscalBuilder comObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public NotaFiscalBuilder naData(LocalDateTime data) {
        this.data = data;
        return this;
    }

    public NotaFiscal build() {
        return new NotaFiscal(nome, cpf, data, valorBruto, impostos, itens, observacoes);
    }
}
