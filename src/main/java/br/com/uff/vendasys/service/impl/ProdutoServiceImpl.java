package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Produto;
import br.com.uff.vendasys.domain.repository.ProdutoRepository;
import br.com.uff.vendasys.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    @Override
    public Produto salvarProduto(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    @Override
    public Produto alterarProduto(Long id, @Valid Produto produtoAlterado) {
        Optional<Produto> produto = buscarPorId(id);

        if (produto.isEmpty()) return null;

        if (Objects.nonNull(produtoAlterado.getNome()))
            produto.get().setNome(produtoAlterado.getNome());
        if (Objects.nonNull(produtoAlterado.getUrlImg()))
            produto.get().setUrlImg(produtoAlterado.getUrlImg());
        if (Objects.nonNull(produtoAlterado.getDescricao()))
            produto.get().setDescricao(produtoAlterado.getDescricao());
        if (Objects.nonNull(produtoAlterado.getCodBarras()))
            produto.get().setCodBarras(produtoAlterado.getCodBarras());
        if (Objects.nonNull(produtoAlterado.getPreco()))
            produto.get().setPreco(produtoAlterado.getPreco());
        if (Objects.nonNull(produtoAlterado.getQtdEstoque()))
            produto.get().setQtdEstoque(produtoAlterado.getQtdEstoque());

        return salvarProduto(produto.get());
    }

    public void promocao() {
        //TODO implementar logica de promocao
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarPorCategoria(String cod) {
        return produtoRepository.buscarPorCategoria(cod);
    }

    @Override
    public List<Produto> buscarAtivos() {
        return produtoRepository.buscarAtivos();
    }

    @Transactional
    @Override
    public void inativarProduto(Long id) {
        Optional<Produto> produto = buscarPorId(id);
        if (produto.isEmpty()) return;
        produto.get().setAtivo(false);
        salvarProduto(produto.get());
    }

    @Transactional
    @Override
    public void removerProduto(Long id) {
        buscarPorId(id).ifPresent(prod -> produtoRepository.delete(prod));
    }
}
