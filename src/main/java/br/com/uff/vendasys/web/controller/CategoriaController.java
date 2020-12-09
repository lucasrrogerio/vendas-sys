package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.service.CategoriaService;
import br.com.uff.vendasys.web.dto.CategoriaDTO;
import br.com.uff.vendasys.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categoria")
@Tag(name = "Categoria")
@CrossOrigin
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    MapperUtil mapper = MapperUtil.getInstance();

    @GetMapping
    public List<CategoriaDTO> buscarTodos() {
        return mapper.toList(categoriaService.buscarTodos(), CategoriaDTO.class);
    }
}
