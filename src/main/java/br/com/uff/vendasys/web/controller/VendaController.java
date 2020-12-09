package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Pagamento;
import br.com.uff.vendasys.domain.entity.Venda;
import br.com.uff.vendasys.service.VendaService;
import br.com.uff.vendasys.service.exception.PagamentoException;
import br.com.uff.vendasys.service.impl.PagamentoCredito;
import br.com.uff.vendasys.service.impl.PagamentoDebito;
import br.com.uff.vendasys.service.impl.PagamentoDinheiro;
import br.com.uff.vendasys.service.impl.PagamentoPix;
import br.com.uff.vendasys.web.dto.PagamentoDTO;
import br.com.uff.vendasys.web.dto.VendaDTO;
import br.com.uff.vendasys.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("venda")
@Tag(name = "Venda")
@CrossOrigin
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
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada",
                    content = { @Content(mediaType = "application/json") })
    })
    @GetMapping("{id}")
    public VendaDTO buscarPorId(@Parameter(description = "id de venda a ser encontrada")
                                    @PathVariable Long id) {
        Venda venda = vendaService.buscarPorId(id);
        if (Objects.isNull(venda))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Cancela uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda cancelada",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) })
    })
    @PutMapping("cancelar/{id}")
    public VendaDTO cancelarVenda(@Parameter(description = "id de venda a ser cancelada")
                                      @PathVariable Long id) {
        Venda venda = vendaService.cancelarVenda(id);
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Registra pagamento em dinheiro para uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento registrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada",
                    content = { @Content(mediaType = "application/json") })
    })
    @PutMapping("{id}/pagamento/dinheiro")
    public VendaDTO registrarPagamentoDinheiro(@Parameter(description = "id da venda sendo paga")
                                                   @PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = mapperUtil.mapTo(pagamentoDTO, Pagamento.class);
        Venda venda = vendaService.registrarPagamento(id, pagamento, new PagamentoDinheiro());
        if (Objects.isNull(venda)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda nao encontrada");
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Registra pagamento em cartao debito para uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento registrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada",
                    content = { @Content(mediaType = "application/json") })
    })
    @PutMapping("{id}/pagamento/debito")
    public VendaDTO registrarPagamentoDebito(@Parameter(description = "id da venda sendo paga")
                                                 @PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = mapperUtil.mapTo(pagamentoDTO, Pagamento.class);
        pagamento.setPagamentoStrategy(new PagamentoDebito());
        Venda venda = vendaService.registrarPagamento(id, pagamento, new PagamentoDebito());
        if (Objects.isNull(venda)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda nao encontrada");
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Registra pagamento em cartao de credito para uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento registrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada",
                    content = { @Content(mediaType = "application/json") })
    })
    @PutMapping("{id}/pagamento/credito")
    public VendaDTO registrarPagamentocredito(@Parameter(description = "id da venda sendo paga")
                                                  @PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = mapperUtil.mapTo(pagamentoDTO, Pagamento.class);
        pagamento.setPagamentoStrategy(new PagamentoCredito());
        Venda venda = vendaService.registrarPagamento(id, pagamento, new PagamentoCredito());
        if (Objects.isNull(venda)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda nao encontrada");
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Registra pagamento em pix para uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento registrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Venda nao encontrada",
                    content = { @Content(mediaType = "application/json") })
    })
    @PutMapping("{id}/pagamento/pix")
    public VendaDTO registrarPagamentoPix(@Parameter(description = "id da venda sendo paga")
                                              @PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = mapperUtil.mapTo(pagamentoDTO, Pagamento.class);
        pagamento.setPagamentoStrategy(new PagamentoPix());
        Venda venda = vendaService.registrarPagamento(id, pagamento, new PagamentoPix());
        if (Objects.isNull(venda)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda nao encontrada");
        return mapperUtil.mapTo(venda, VendaDTO.class);
    }

    @Operation(summary = "Registra pagamento em dinheiro para uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento registrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VendaDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Problema com pagamento",
                    content = { @Content(mediaType = "application/json") })
    })
    @PutMapping("finalizar/{id}")
    public void finalizarVenda(@Parameter(description = "id de venda a ser finalizada")
                                   @PathVariable Long id) {
        try {
            vendaService.finalizar(id);
        } catch (PagamentoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
