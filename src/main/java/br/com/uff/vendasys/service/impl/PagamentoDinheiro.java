package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoDinheiro implements PagamentoStrategy {

    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        pagamento.setTroco(calcularTroco());
        return null;
    }

    private Double calcularTroco() {
        return null;
    }
}
