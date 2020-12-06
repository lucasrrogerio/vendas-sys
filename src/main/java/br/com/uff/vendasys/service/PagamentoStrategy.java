package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Pagamento;

public interface PagamentoStrategy {
    Pagamento registrarPagamento(Pagamento pagamento);
}
