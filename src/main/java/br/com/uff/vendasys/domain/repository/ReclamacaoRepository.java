package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Reclamacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long> {
}
