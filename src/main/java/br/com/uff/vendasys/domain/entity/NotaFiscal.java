package br.com.uff.vendasys.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

public class NotaFiscal {

    private String nome;
    private String cpf;
    private LocalDateTime dataDeEmissao;
    private Double valorBruto;
    private Double impostos;
    public List<ItemVenda> itens;
    public String observacoes;

    public NotaFiscal(String nome, String cpf, LocalDateTime dataDeEmissao,
                      Double valorBruto, Double impostos, List<ItemVenda> itens,
                      String observacoes) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeEmissao = dataDeEmissao;
        this.valorBruto = valorBruto;
        this.impostos = impostos;
        this.itens = itens;
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getDataDeEmissao() {
        return dataDeEmissao;
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public Double getImpostos() {
        return impostos;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public String getObservacoes() {
        return observacoes;
    }

}
