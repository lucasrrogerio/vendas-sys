package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Usuario;

import javax.validation.Valid;
import java.util.List;

public interface UsuarioService {

    Usuario salvarUsuario(@Valid Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario buscarPorEmail(String email);
    List<Usuario> buscarTodosVendedores();
    Usuario alterarUsuario(Long id, @Valid Usuario usuario);
    void removerUsuario(Long id);
}
