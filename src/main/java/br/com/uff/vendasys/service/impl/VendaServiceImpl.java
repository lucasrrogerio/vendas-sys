package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.NotaFiscal;
import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.domain.enums.StatusVenda;
import br.com.uff.vendasys.domain.repository.ReclamacaoRepository;
import br.com.uff.vendasys.domain.repository.VendaRepository;
import br.com.uff.vendasys.service.PagamentoStrategy;
import br.com.uff.vendasys.service.VendaService;
import br.com.uff.vendasys.service.builder.NotaFiscalBuilder;
import br.com.uff.vendasys.service.exception.PagamentoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
        return vendaRepository.save(venda);
    }

    @Override
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    @Override
    public Venda cancelarVenda(Long id) {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return  null;
        venda.setStatusVenda(StatusVenda.CANCELADA);
        return vendaRepository.save(venda);
    }

    @Override
    public Venda registrarPagamento(Long id, Pagamento pagamento, PagamentoStrategy strategy) {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return null;
        Pagamento pagamentoVenda = new Pagamento(strategy);
        pagamentoVenda.getPagamentoStrategy().registrarPagamento(pagamento);
        venda.setPagamento(pagamentoVenda);
        vendaRepository.save(venda);
        return venda;
    }

    @Override
    public void finalizar(Long id) throws PagamentoException {
        Venda venda = buscarPorId(id);
        if (Objects.isNull(venda)) return;
        if (venda.getPagamento().isPago()) throw new PagamentoException("Pagamento nao realizado");
        venda.setNotaFiscal(gerarNotaFiscal(venda));
        venda.setStatusVenda(StatusVenda.FINALIZADA);
        vendaRepository.save(venda);
    }

    private NotaFiscal gerarNotaFiscal(Venda venda) {
        NotaFiscalBuilder nfBuilder = new NotaFiscalBuilder();
        return nfBuilder
                .paraCliente(venda.getCliente().getNome())
                .comCpf(venda.getCliente().getCpf())
                .comItens(venda.getItens())
                .naData(LocalDateTime.now())
                .build();
    }

}
