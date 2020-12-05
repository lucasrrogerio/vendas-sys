package br.com.uff.vendasys.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {
    UserDetails buscarUsuarioPorEmail(String email);
}
