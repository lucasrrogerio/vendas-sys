package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.service.UsuarioService;
import br.com.uff.vendasys.web.dto.UsuarioDTO;
import br.com.uff.vendasys.web.mapper.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = mapperUtil.mapTo(usuarioDTO, Usuario.class);
        return mapperUtil.mapTo(usuarioService.salvarUsuario(usuario), UsuarioDTO.class);
    }

    @GetMapping("{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
        return mapperUtil.mapTo(usuario, UsuarioDTO.class);
    }

    @GetMapping("vendedores")
    public List<UsuarioDTO> buscarTodosVendedores() {
        return mapperUtil.toList(usuarioService.buscarTodosVendedores(), UsuarioDTO.class);
    }

    @PutMapping("{id}")
    public UsuarioDTO alterarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.alterarUsuario(id, mapperUtil.mapTo(usuarioDTO, Usuario.class));
        if (Objects.isNull(usuario))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        return mapperUtil.mapTo(usuario, UsuarioDTO.class);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Long id) {
        if (usuarioService.buscarPorId(id).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        usuarioService.removerUsuario(id);
    }
}
