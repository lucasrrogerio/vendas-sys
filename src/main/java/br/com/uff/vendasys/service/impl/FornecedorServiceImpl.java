package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Fornecedor;
import br.com.uff.vendasys.domain.repository.FornecedorRepository;
import br.com.uff.vendasys.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }
}
