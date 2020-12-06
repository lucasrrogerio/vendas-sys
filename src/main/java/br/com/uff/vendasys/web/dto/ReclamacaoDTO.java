package br.com.uff.vendasys.web.dto;

import br.com.uff.vendasys.domain.entity.Venda;

import java.time.LocalDateTime;

public class ReclamacaoDTO {

    private LocalDateTime data;
    private String comentario;
    private Venda venda;

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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
