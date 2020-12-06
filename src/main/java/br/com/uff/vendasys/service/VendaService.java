package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.ItemVenda;
import br.com.uff.vendasys.domain.entity.Venda;

import java.util.Date;
import java.util.List;

public interface VendaService {

    Venda iniciarVenda(Venda venda);
    Venda buscarPorId(Long id);
    Venda adicionarItem(Long id, ItemVenda item);
    Double calcularTotal(Long id);
    List<Venda> listarVendasPorData(Date data);
    Venda registrarReclamacao(Venda venda);
    Venda cancelarVenda(Long id);
    void registrarPagamento(Venda venda, PagamentoStrategy pagamentoStrategy);
}
