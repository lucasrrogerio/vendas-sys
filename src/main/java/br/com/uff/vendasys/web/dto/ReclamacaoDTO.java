package br.com.uff.vendasys.web.dto;

import java.time.LocalDateTime;

public class ReclamacaoDTO {

    private LocalDateTime data;
    private String comentario;
    private ClienteDTO clienteDTO;

    public ReclamacaoDTO() {
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }
}
