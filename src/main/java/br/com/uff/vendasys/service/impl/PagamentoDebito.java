package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.service.PagamentoStrategy;

public class PagamentoDebito implements PagamentoStrategy {
    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        pagamento.setPago(conectarMaquinaDebito());
        return pagamento;
    }

    /**
     * Tenta conexao com maquina de cartao para efetuar pagamento
     * @return true se sucesso na conexao, senao false
     */
    private boolean conectarMaquinaDebito() {
        boolean sucesso;
        // codigo para tentar conexao e setar sucesso
        sucesso = true;
        return sucesso;
    }
}
