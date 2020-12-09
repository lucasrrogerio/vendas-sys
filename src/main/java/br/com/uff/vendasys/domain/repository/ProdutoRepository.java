package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.isAtivo = TRUE")
    List<Produto> buscarAtivos();

    @Query("SELECT p FROM Produto p WHERE p.categoria.codigo = :codigo")
    List<Produto> buscarPorCategoria(String codigo);
}
