package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
