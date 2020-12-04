package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c where LOWER(c.cpf) = LOWER(:cpf)")
    Cliente buscarPorCpf(String cpf);
}
