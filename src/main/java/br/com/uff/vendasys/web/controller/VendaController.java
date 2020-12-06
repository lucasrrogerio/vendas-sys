package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Reclamacao;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.VendaService;
import br.com.uff.vendasys.service.exception.PagamentoException;
import br.com.uff.vendasys.service.impl.PagamentoCredito;
import br.com.uff.vendasys.service.impl.PagamentoDebito;
import br.com.uff.vendasys.service.impl.PagamentoDinheiro;
import br.com.uff.vendasys.service.impl.PagamentoPix;
import br.com.uff.vendasys.web.dto.ReclamacaoDTO;
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

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("venda")
@Tag(name = "Venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Inicializa uma venda com status ABERTA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venda iniciada")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long iniciarVenda(@RequestBody VendaDTO vendaDTO) {
        Venda venda = mapperUtil.mapTo(vendaDTO, Venda.class);
        return vendaService.iniciarVenda(venda).getId();
    }

    @Operation(summary = "Busca venda por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda encontrada",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada")
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

    @PostMapping("reclamacao")
    public void registrarReclamacao(Long id, ReclamacaoDTO reclamacaoDTO) {
        vendaService.registrarReclamacao(id, mapperUtil.mapTo(reclamacaoDTO, Reclamacao.class));
    }

    @PutMapping("cancelar")
    public VendaDTO cancelarVenda(Long id) {
        Venda venda = vendaService.cancelarVenda(id);
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @PutMapping("pagamento/dinheiro")
    public VendaDTO registrarPagamentoDinheiro(Long id) {
        Venda venda = vendaService.registrarPagamento(id, new PagamentoDinheiro());
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @PutMapping("pagamento/debito")
    public VendaDTO registrarPagamentoDebito(Long id) {
        Venda venda = vendaService.registrarPagamento(id, new PagamentoDebito());
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @PutMapping("pagamento/credito")
    public VendaDTO registrarPagamentocredito(Long id) {
        Venda venda = vendaService.registrarPagamento(id, new PagamentoCredito());
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @PutMapping("pagamento/pix")
    public VendaDTO registrarPagamentoPix(Long id) {
        Venda venda = vendaService.registrarPagamento(id, new PagamentoPix());
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @PutMapping("finalizar")
    public void finalizarVenda(Long id) {
        try {
            vendaService.finalizar(id);
        } catch (PagamentoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pagamento nao finalizado");
        }
    }

}
