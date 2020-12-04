package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Produto;
import br.com.uff.vendasys.service.ProdutoService;
import br.com.uff.vendasys.web.dto.ProdutoDTO;
import br.com.uff.vendasys.web.mapper.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping
    public ProdutoDTO salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = mapperUtil.mapTo(produtoDTO, Produto.class);
        Produto salvo = produtoService.salvarProduto(produto);
        return mapperUtil.mapTo(salvo, ProdutoDTO.class);
    }

    @GetMapping("{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        if (Objects.isNull(produto))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }

    @GetMapping
    public List<ProdutoDTO> buscarTodos() {
        return mapperUtil.toList(produtoService.buscarTodos(), ProdutoDTO.class);
    }

    @GetMapping("ativos")
    public List<ProdutoDTO> buscarAtivos() {
        return mapperUtil.toList(produtoService.buscarAtivos(), ProdutoDTO.class);
    }

    @GetMapping("categoria/{cod}")
    public List<ProdutoDTO> buscarPorCategoria(@PathVariable String cod) {
        return mapperUtil.toList(produtoService.buscarPorCategoria(cod), ProdutoDTO.class);
    }

    @PutMapping("{id}")
    public ProdutoDTO alterarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.alterarProduto(id, mapperUtil.mapTo(produtoDTO, Produto.class));
        if (Objects.isNull(produto))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }

    @PutMapping("inativar/{id}")
    public ProdutoDTO inativar(@PathVariable Long id) {
        Produto produto = produtoService.inativarProduto(id);
        if (Objects.isNull(produto))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Long id) {
        if (Objects.isNull(produtoService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        produtoService.removerProduto(id);
    }

}
