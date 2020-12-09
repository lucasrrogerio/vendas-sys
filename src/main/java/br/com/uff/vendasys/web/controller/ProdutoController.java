package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Produto;
import br.com.uff.vendasys.service.ProdutoService;
import br.com.uff.vendasys.web.dto.CategoriaDTO;
import br.com.uff.vendasys.web.dto.ProdutoDTO;
import br.com.uff.vendasys.web.utils.MapperUtil;
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
@RequestMapping("produto")
@Tag(name = "Produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Salva um produto novo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class)) })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = mapperUtil.mapTo(produtoDTO, Produto.class);
        Produto salvo = produtoService.salvarProduto(produto);
        return mapperUtil.mapTo(salvo, ProdutoDTO.class);
    }

    @Operation(summary = "Busca um produto por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Produto nao encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public ProdutoDTO buscarPorId(@Parameter(description = "id de produto a ser encontrado") @PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        if (Objects.isNull(produto))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }

    @Operation(summary = "Retorna todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoDTO.class))) })
    })
    @GetMapping
    public List<ProdutoDTO> buscarTodos() {
        return mapperUtil.toList(produtoService.buscarTodos(), ProdutoDTO.class);
    }

    @Operation(summary = "Retorna todos os produtos ativos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos ativos encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoDTO.class))) })
    })
    @GetMapping("ativos")
    public List<ProdutoDTO> buscarAtivos() {
        return mapperUtil.toList(produtoService.buscarAtivos(), ProdutoDTO.class);
    }

    @Operation(summary = "Busca produtos por categira")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos de uma categoria encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoDTO.class))) })
    })
    @GetMapping("categoria/{cod}")
    public List<ProdutoDTO> buscarPorCategoria(@Parameter(description = "codigo da categoria de produtos")@PathVariable String cod) {
        return mapperUtil.toList(produtoService.buscarPorCategoria(cod), ProdutoDTO.class);
    }

    @Operation(summary = "Altera um produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto alterado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Produto nao encontrado", content = @Content)
    })
    @PutMapping("{id}")
    public ProdutoDTO alterarProduto(@Parameter(description = "id de produto a ser encontrado") @PathVariable Long id,
                                     @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.alterarProduto(id, mapperUtil.mapTo(produtoDTO, Produto.class));
        if (Objects.isNull(produto))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }

    @Operation(summary = "Inativa um produto buscando por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto inativado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Produto nao encontrado", content = @Content)
    })
    @PutMapping("inativar/{id}")
    public ProdutoDTO inativar(@Parameter(description = "id de produto a ser inativado") @PathVariable Long id) {
        Produto produto = produtoService.inativarProduto(id);
        if (Objects.isNull(produto))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        return mapperUtil.mapTo(produto, ProdutoDTO.class);
    }

    @Operation(summary = "Remove um produto por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto nao encontrado", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@Parameter(description = "id de produto a ser removido") @PathVariable Long id) {
        if (Objects.isNull(produtoService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        produtoService.removerProduto(id);
    }

}
