package br.com.helpets.helpetsapi.repository;

import br.com.helpets.helpetsapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Transactional
    @Modifying
    @Query(value = "update Usuario u set u.nome = :nome where u.id = :id")
    void updateNome(@Param("nome") String nome, @Param("id") Long id);

    Usuario findByNome(String nome);

}
