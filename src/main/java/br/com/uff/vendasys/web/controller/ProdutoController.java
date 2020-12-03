package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Produto;
import br.com.uff.vendasys.service.ProdutoService;
import br.com.uff.vendasys.web.dto.ProdutoDTO;
import br.com.uff.vendasys.web.mapper.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @GetMapping("{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }
}
