package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Cliente;
import br.com.uff.vendasys.domain.entity.Reclamacao;
import br.com.uff.vendasys.domain.repository.ClienteRepository;
import br.com.uff.vendasys.domain.repository.ReclamacaoRepository;
import br.com.uff.vendasys.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ReclamacaoRepository reclamacaoRepository;

    @Override
    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.buscarPorCpf(cpf);
    }

    @Override
    public List<Cliente> buscarVips() {
        return clienteRepository.buscarVips();
    }

    @Override
    public void removerCliente(Long id) {
        if (Objects.nonNull(buscarPorId(id)))
            clienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void registrarReclamacao(Long idCliente, Reclamacao reclamacao) {
        Cliente cliente = buscarPorId(idCliente);
        if (Objects.nonNull(cliente)) {
            reclamacao.setCliente(cliente);
            reclamacaoRepository.save(reclamacao);
        }
    }

}
