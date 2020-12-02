package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProdutoService {

    Optional<Produto> buscarPorId(Long id);
}
