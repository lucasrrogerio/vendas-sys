package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.domain.repository.UsuarioRepository;
import br.com.uff.vendasys.service.AuthService;
import br.com.uff.vendasys.service.exception.LoginUsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Usuario login(Usuario usuario) {
        Usuario usuarioAutenticado = usuarioRepository.login(usuario.getEmail(), usuario.getSenha());
        if (Objects.isNull(usuarioAutenticado)) throw new LoginUsuarioException("Usuario nao autenticado");
        return usuarioAutenticado;
    }
}
