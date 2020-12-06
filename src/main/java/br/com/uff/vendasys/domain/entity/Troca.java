package br.com.uff.vendasys.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Troca {

    @Id
    @GeneratedValue
    private Long id;
    @PastOrPresent
    private LocalDateTime data;
    @OneToOne
    private ItemVenda produto;
    private String motivo;

    public Troca() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ItemVenda getProduto() {
        return produto;
    }

    public void setProduto(ItemVenda produto) {
        this.produto = produto;
    }
}
