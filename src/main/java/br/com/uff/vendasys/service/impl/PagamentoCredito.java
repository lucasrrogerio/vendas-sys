package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoCredito implements PagamentoStrategy {

    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        pagamento.setPago(conectarMaquinaCredito());
        return pagamento;
    }

    /**
     * Tenta conexao com maquina de cartao para efetuar pagamento
     * @return true se sucesso na conexao, senao false
     */
    private boolean conectarMaquinaCredito() {
        boolean sucesso;
        // codigo para tentar conexao e setar sucesso
        sucesso = true;
        return sucesso;
    }
}
