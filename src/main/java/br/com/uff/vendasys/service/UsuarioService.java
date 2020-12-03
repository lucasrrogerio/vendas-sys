package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Usuario;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario criarUsuario(@Valid Usuario usuario);
    public Optional<Usuario> buscarPorId(Long id);
    public Optional<Usuario> buscarPorEmail(String email);
    public List<Usuario> buscarTodosVendedores();
    public Usuario alterarUsuario(@Valid Usuario usuario);
    public void removerUsuario(Long id);
}
