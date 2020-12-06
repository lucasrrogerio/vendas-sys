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
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Produto alterarProduto(Long id, @Valid Produto produtoAlterado) {
        Produto produto = buscarPorId(id);

        if (Objects.isNull(produto)) return null;

        if (Objects.nonNull(produtoAlterado.getNome()))
            produto.setNome(produtoAlterado.getNome());
        if (Objects.nonNull(produtoAlterado.getUrlImg()))
            produto.setUrlImg(produtoAlterado.getUrlImg());
        if (Objects.nonNull(produtoAlterado.getDescricao()))
            produto.setDescricao(produtoAlterado.getDescricao());
        if (Objects.nonNull(produtoAlterado.getCodigoBarras()))
            produto.setCodigoBarras(produtoAlterado.getCodigoBarras());
        if (Objects.nonNull(produtoAlterado.getPreco()))
            produto.setPreco(produtoAlterado.getPreco());
        produto.setQtdEstoque(produtoAlterado.getQtdEstoque());
        return salvarProduto(produto);
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
    public Produto inativarProduto(Long id) {
        Produto produto = buscarPorId(id);
        if (Objects.isNull(produto)) return null;
        produto.setAtivo(false);
        return salvarProduto(produto);
    }

    @Transactional
    @Override
    public void removerProduto(Long id) {
        Produto produto = buscarPorId(id);
        if (Objects.nonNull(produto)) produtoRepository.delete(produto);
    }
}
