package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.domain.entity.Reclamacao;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.domain.enums.StatusVenda;
import br.com.uff.vendasys.domain.repository.ReclamacaoRepository;
import br.com.uff.vendasys.domain.repository.VendaRepository;
import br.com.uff.vendasys.service.PagamentoStrategy;
import br.com.uff.vendasys.service.VendaService;
import br.com.uff.vendasys.service.exception.PagamentoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class VendaServiceImpl implements VendaService {

    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    ReclamacaoRepository reclamacaoRepository;

    @Override
    public Venda iniciarVenda(Venda venda) {
        // TODO usar builder
        //Venda venda = new Venda();
        return vendaRepository.save(venda);
    }

    @Override
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venda> listarVendasPorData(Date data) {
        return vendaRepository.listarPorData(data);
    }

    @Override
    public void registrarReclamacao(Long idVenda, Reclamacao reclamacao) {
        Venda venda = buscarPorId(idVenda);
        if (Objects.nonNull(venda)) {
            reclamacao.setVenda(venda);
            reclamacaoRepository.save(reclamacao);
        }
    }

    @Override
    public Venda cancelarVenda(Long id) {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return  null;
        venda.setStatusVenda(StatusVenda.CANCELADA);
        return vendaRepository.save(venda);
    }

    @Override
    public Venda registrarPagamento(Long id, PagamentoStrategy pagamentoStrategy) {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return  null;
        Pagamento pagamento = venda.getPagamento();
        pagamento.setPagamentoStrategy(pagamentoStrategy);
        pagamento.getPagamentoStrategy().registrarPagamento(venda.getPagamento());
        return  null;
    }

    @Override
    public void finalizar(Long id) throws PagamentoException {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return;
        if (venda.getPagamento().isPago()) throw new PagamentoException("Pagamento nao realizado");
        venda.setStatusVenda(StatusVenda.FINALIZADA);
        vendaRepository.save(venda);
    }

}
