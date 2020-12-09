package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Categoria;
import br.com.uff.vendasys.domain.repository.CategoriaRepository;
import br.com.uff.vendasys.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> buscarTodos() {
        return  categoriaRepository.findAll();
    }
}
