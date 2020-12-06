package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente salvarCliente(Cliente cliente);
    Cliente buscarPorId(Long id);
    Cliente buscarPorCpf(String cpf);
    List<Cliente> buscarVips();

}
