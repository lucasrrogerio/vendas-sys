package br.com.uff.vendasys.domain.repository;

import br.com.uff.vendasys.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO gerado pelo Spring DATA
 * codigo boilerplate simplificado pelo Spring com JPA
 * queries especificas criadas com ajuda de anotacao
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u where LOWER(u.email) = LOWER(:email)")
    Usuario buscarPorEmail(String email);

    @Query("SELECT u FROM Usuario u where u.tipoUsuario = 'VENDEDOR'")
    List<Usuario> buscarTodosVendedores();

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    Usuario login(@Param("email") String email, @Param("senha") String senha);
}
