package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.service.UsuarioService;
import br.com.uff.vendasys.web.dto.UsuarioDTO;
import br.com.uff.vendasys.web.mapper.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("usuario")
@Tag(name = "Usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Cria um novo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Usuario invalido", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = mapperUtil.mapTo(usuarioDTO, Usuario.class);
        return mapperUtil.mapTo(usuarioService.salvarUsuario(usuario), UsuarioDTO.class);
    }

    @Operation(summary = "Busca um usuario por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Usuario nao encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@Parameter(description = "id do usuario a ser buscado") @PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
        return mapperUtil.mapTo(usuario, UsuarioDTO.class);
    }

    @Operation(summary = "Busca usuarios do tipo vendedor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioDTO.class))) })
    })
    @GetMapping("vendedores")
    public List<UsuarioDTO> buscarTodosVendedores() {
        return mapperUtil.toList(usuarioService.buscarTodosVendedores(), UsuarioDTO.class);
    }

    @Operation(summary = "Altera um usuario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Usuario nao encontrado", content = @Content)
    })
    @PutMapping("{id}")
    public UsuarioDTO alterarUsuario(@Parameter(description = "id de usuario a ser alterado") @PathVariable Long id,
                                     @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.alterarUsuario(id, mapperUtil.mapTo(usuarioDTO, Usuario.class));
        if (Objects.isNull(usuario))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        return mapperUtil.mapTo(usuario, UsuarioDTO.class);
    }

    @Operation(summary = "Remove um usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario removido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario nao encontrado", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@Parameter(description = "id de usuario a ser removido") @PathVariable Long id) {
        if (usuarioService.buscarPorId(id).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        usuarioService.removerUsuario(id);
    }
}
