package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.service.ProdutoService;
import br.com.uff.vendasys.web.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        produtoService.buscarPorId(id).orElse(null);
        return null;
    }
}
