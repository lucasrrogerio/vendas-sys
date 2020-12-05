package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    @Query("SELECT p FROM Privilege p WHERE p.name = :name")
    Privilege findbyName(String name);
}
