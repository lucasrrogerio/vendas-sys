package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.domain.repository.RoleRepository;
import br.com.uff.vendasys.domain.repository.UsuarioRepository;
import br.com.uff.vendasys.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.beans.Encoder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;

    @Transactional
    @Override
    public Usuario salvarUsuario(@Valid Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuario.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
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
    public Usuario alterarUsuario(Long id, Usuario usuarioAlterado) {
        Optional<Usuario> usuario = buscarPorId(id);
        if (usuario.isEmpty()) return null;
        if (Objects.nonNull(usuarioAlterado.getNome()))
            usuario.get().setNome(usuarioAlterado.getNome());
        if (Objects.nonNull(usuarioAlterado.getEmail()))
            usuario.get().setEmail(usuarioAlterado.getEmail());
        if (Objects.nonNull(usuarioAlterado.getTipoUsuario()))
            usuario.get().setTipoUsuarioEnum(usuarioAlterado.getTipoUsuarioEnum());
        return salvarUsuario(usuario.get());
    }

    @Transactional
    @Override
    public void removerUsuario(Long id) {
        buscarPorId(id).ifPresent(usuario -> usuarioRepository.delete(usuario));
    }
}
