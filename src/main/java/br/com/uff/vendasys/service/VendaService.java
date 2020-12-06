package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Reclamacao;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.exception.PagamentoException;

import java.util.Date;
import java.util.List;

public interface VendaService {

    Venda iniciarVenda(Venda venda);
    Venda buscarPorId(Long id);
    List<Venda> listarVendasPorData(Date data);
    void registrarReclamacao(Long idVenda, Reclamacao reclamacao);
    Venda cancelarVenda(Long id);
    Venda registrarPagamento(Long id, PagamentoStrategy pagamentoStrategy);
    void finalizar(Long id) throws PagamentoException;
}
