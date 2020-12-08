package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Cliente;
import br.com.uff.vendasys.domain.entity.Reclamacao;

import java.util.List;

public interface ClienteService {
    Cliente salvarCliente(Cliente cliente);
    Cliente buscarPorId(Long id);
    Cliente buscarPorCpf(String cpf);
    List<Cliente> buscarVips();
    void removerCliente(Long id);
    void registrarReclamacao(Long idVenda, Reclamacao reclamacao);
}
