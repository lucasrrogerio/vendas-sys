package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Produto;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.ProdutoService;
import br.com.uff.vendasys.service.VendaService;
import br.com.uff.vendasys.web.dto.ProdutoDTO;
import br.com.uff.vendasys.web.dto.VendaDTO;
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

import java.util.*;

@RestController
@RequestMapping("venda")
@Tag(name = "Venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venda iniciada")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long iniciarVenda(@RequestBody VendaDTO vendaDTO) {
        Venda venda = mapperUtil.mapTo(vendaDTO, Venda.class);
        return null;
    }

    @Operation(summary = "Busca venda por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda encontrada",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada", content = @Content)
    })
    @GetMapping("{id}")
    public VendaDTO buscarPorId(@Parameter(description = "id de venda a ser encontrada") @PathVariable Long id) {
        Venda venda = vendaService.buscarPorId(id);
        if (Objects.isNull(venda))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Retorna vendas ocorridas em uma data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vendas encontradas",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VendaDTO.class))) })
    })
    @GetMapping("{data}")
    public List<VendaDTO> listarPorData(@PathVariable Date data) {
        return mapperUtil.toList(vendaService.listarVendasPorData(data), VendaDTO.class);
    }

    @PostMapping("pagamento")
    public Map<String, String> registrarPagamentoDinheiro(VendaDTO vendaDTO) {
        vendaService.registrarPagamentoDinheiro(mapperUtil.mapTo(vendaDTO, Venda.class));
        return Collections.singletonMap("message", "pagamento realizado com sucesso!");
    }
}
