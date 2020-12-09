package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoDinheiro implements PagamentoStrategy {

    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        pagamento.setTroco(pagamento.getTotalVenda() - pagamento.getTotalPago());
        pagamento.setPago(true);
        return pagamento;
    }
}
