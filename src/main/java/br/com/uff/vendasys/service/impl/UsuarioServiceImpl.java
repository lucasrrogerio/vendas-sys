package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.domain.repository.UsuarioRepository;
import br.com.uff.vendasys.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public Usuario criarUsuario(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.buscarPorEmail(email));
    }

    @Override
    public List<Usuario> buscarTodosVendedores() {
        return usuarioRepository.buscarTodosVendedores();
    }

    @Transactional
    @Override
    public Usuario alterarUsuario(Usuario usuarioAlterado) {
        Usuario usuario = new Usuario();
        if (Objects.nonNull(usuarioAlterado.getNome()))
            usuario.setNome(usuarioAlterado.getNome());
        if (Objects.nonNull(usuarioAlterado.getTipoUsuario()))
            usuario.setTipoUsuarioEnum(usuarioAlterado.getTipoUsuarioEnum());
        return criarUsuario(usuario);
    }

    @Override
    public void removerUsuario(Long id) {
        buscarPorId(id).ifPresent(usuario -> usuarioRepository.delete(usuario));
    }
}
