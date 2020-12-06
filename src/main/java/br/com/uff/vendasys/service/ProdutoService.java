package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Produto;

import javax.validation.Valid;
import java.util.List;

public interface ProdutoService {

    Produto salvarProduto(@Valid Produto produto);
    Produto buscarPorId(Long id);
    Produto alterarProduto(Long id, @Valid Produto produto);
    List<Produto> buscarTodos();
    List<Produto> buscarPorCategoria(String cod);
    List<Produto> buscarAtivos();
    Produto inativarProduto(Long id);
    void removerProduto(Long id);
}
