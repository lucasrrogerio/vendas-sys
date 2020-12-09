package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.service.FornecedorService;
import br.com.uff.vendasys.web.dto.FornecedorDTO;
import br.com.uff.vendasys.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fornecedor")
@Tag(name = "Fornecedor")
@CrossOrigin
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @GetMapping
    public List<FornecedorDTO> buscarTodos() {
        return mapperUtil.toList(fornecedorService.buscarTodos(), FornecedorDTO.class);
    }
}
