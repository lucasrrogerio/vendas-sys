package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoCredito implements PagamentoStrategy {
    @Override
    public Venda registrarPagamento(Venda venda) {
        return null;
    }
}
