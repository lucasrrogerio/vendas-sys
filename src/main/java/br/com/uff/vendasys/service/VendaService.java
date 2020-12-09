package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.exception.PagamentoException;

public interface VendaService {

    Venda iniciarVenda(Venda venda);
    Venda buscarPorId(Long id);
    Venda cancelarVenda(Long id);
    Venda registrarPagamento(Long id, Pagamento pagamento, PagamentoStrategy strategy);
    void finalizar(Long id) throws PagamentoException;
}
