package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoDinheiro implements PagamentoStrategy {
    @Override
    public Venda registrarPagamento(Venda venda) {
        calcularTroco();
        return venda;
    }

    private Double calcularTroco() {
        return null;
    }
}
