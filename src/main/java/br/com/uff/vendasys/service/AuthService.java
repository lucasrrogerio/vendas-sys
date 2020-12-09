package br.com.uff.vendasys.service;

import br.com.uff.vendasys.domain.entity.Usuario;

public interface AuthService {

    Usuario login(Usuario usuario);
}
