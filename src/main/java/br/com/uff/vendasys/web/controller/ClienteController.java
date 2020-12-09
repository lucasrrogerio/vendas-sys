package br.com.uff.vendasys.web.controller;

import br.com.uff.vendasys.domain.entity.Cliente;
import br.com.uff.vendasys.domain.entity.Reclamacao;
import br.com.uff.vendasys.service.ClienteService;
import br.com.uff.vendasys.web.dto.ClienteDTO;
import br.com.uff.vendasys.web.dto.ReclamacaoDTO;
import br.com.uff.vendasys.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("cliente")
@Tag(name = "Cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping
    public ClienteDTO salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.salvarCliente(mapperUtil.mapTo(clienteDTO, Cliente.class));
        return mapperUtil.mapTo(cliente, ClienteDTO.class);
    }

    @GetMapping("{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (Objects.isNull(cliente))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encotnrado");
        return mapperUtil.mapTo(cliente, ClienteDTO.class);
    }

    @GetMapping("cpf/{cpf}")
    public ClienteDTO buscarPorCpf(@PathVariable @CPF String cpf) {
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        if (Objects.isNull(cliente))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encotnrado");
        return mapperUtil.mapTo(cliente, ClienteDTO.class);
    }

    @GetMapping("vips")
    public List<ClienteDTO> buscarVips() {
        return mapperUtil.toList(clienteService.buscarVips(), ClienteDTO.class);
    }

    @DeleteMapping("{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
    }

    @PutMapping("{id}/reclamacao")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> registrarReclamacao(@PathVariable Long id, @RequestBody ReclamacaoDTO reclamacaoDTO) {
        clienteService.registrarReclamacao(id, mapperUtil.mapTo(reclamacaoDTO, Reclamacao.class));
        return Collections.singletonMap("message", "Reclamcao registrada.");
    }
}
