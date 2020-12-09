package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoPix implements PagamentoStrategy {
    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        pagamento.setPago(pagarComPix());
        return pagamento;
    }

    /**
     * Lógica de pagamento com pix
     * @retorn true se sucesso, senao false
     */
    private boolean pagarComPix() {
        return true;
    }
}
