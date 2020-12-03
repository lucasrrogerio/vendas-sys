package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Produto;
import br.com.uff.vendasys.domain.repository.ProdutoRepository;
import br.com.uff.vendasys.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
}
