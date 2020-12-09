package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> buscarTodos();
}
