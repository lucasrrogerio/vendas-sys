package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.ItemVenda;
import br.com.uff.vendasys.domain.entity.Venda;

import java.util.Date;
import java.util.List;

public interface VendaService {

    void iniciarVenda();
    Venda buscarPorId(Long id);
    Venda adicionarItem(Long id, ItemVenda item);
    Double calcularTotal(Long id);
    List<Venda> listarVendasPorData(Date data);
    void registrarPagamentoDinheiro(Venda venda);
    void registrarPagamentoDebito(Venda venda);
    void registrarPagamentoCredito(Venda venda);
    void registrarPagamentoPix(Venda venda);

}
