package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
