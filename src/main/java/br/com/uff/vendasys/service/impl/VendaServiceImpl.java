package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.ItemVenda;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.VendaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VendaServiceImpl implements VendaService {

    @Override
    public void iniciarVenda() {

    }

    @Override
    public Venda buscarPorId(Long id) {
        return null;
    }

    @Override
    public Venda adicionarItem(Long id, ItemVenda item) {
        return null;
    }

    @Override
    public Double calcularTotal(Long id) {
        return null;
    }

    @Override
    public List<Venda> listarVendasPorData(Date data) {
        return null;
    }

    @Override
    public void registrarPagamentoDinheiro(Venda venda) {
        venda.setPagamento(new PagamentoDinheiro());
        venda.pagamento.registrarPagamento();
    }

    @Override
    public void registrarPagamentoDebito(Venda venda) {
        venda.setPagamento(new PagamentoDebito());
        venda.pagamento.registrarPagamento();
    }

    @Override
    public void registrarPagamentoCredito(Venda venda) {
        venda.setPagamento(new PagamentoCredito());
        venda.pagamento.registrarPagamento();
    }

    @Override
    public void registrarPagamentoPix(Venda venda) {
        venda.setPagamento(new PagamentoPix());
        venda.pagamento.registrarPagamento();
    }

}
