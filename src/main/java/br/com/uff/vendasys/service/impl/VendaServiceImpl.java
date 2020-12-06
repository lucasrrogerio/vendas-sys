package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.ItemVenda;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.domain.enums.StatusVenda;
import br.com.uff.vendasys.domain.repository.VendaRepository;
import br.com.uff.vendasys.service.PagamentoStrategy;
import br.com.uff.vendasys.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    VendaRepository vendaRepository;

    @Override
    public Venda iniciarVenda(Venda venda) {
        // TODO usar builder
        //Venda venda = new Venda();
        return vendaRepository.save(venda);
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
    public Venda registrarReclamacao(Venda venda) {
        return null;
    }

    @Override
    public Venda cancelarVenda(Long id) {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return  null;
        venda.setStatusVenda(StatusVenda.CANCELADA);
        return vendaRepository.save(venda);
    }

    @Override
    public void registrarPagamento(Venda venda, PagamentoStrategy pagamentoStrategy) {
        venda.getPagamento().setPagamentoStrategy(pagamentoStrategy);
        venda.getPagamento().pagamentoStrategy.registrarPagamento(venda.getPagamento());
    }

}
