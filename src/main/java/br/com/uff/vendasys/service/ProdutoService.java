package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Produto;

import java.util.Optional;

public interface ProdutoService {

    Optional<Produto> buscarPorId(Long id);
}
