package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.service.AuthService;
import br.com.uff.vendasys.service.UsuarioService;
import br.com.uff.vendasys.service.exception.LoginUsuarioException;
import br.com.uff.vendasys.web.dto.UsuarioDTO;
import br.com.uff.vendasys.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("auth")
@Tag(name = "auth")
@CrossOrigin
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AuthService authService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping("login")
    public UsuarioDTO login (@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = authService.login(mapperUtil.mapTo(usuarioDTO, Usuario.class));
            return mapperUtil.mapTo(usuario, UsuarioDTO.class);
        } catch (LoginUsuarioException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
