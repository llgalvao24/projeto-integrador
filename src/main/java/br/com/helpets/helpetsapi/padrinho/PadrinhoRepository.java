package br.com.helpets.helpetsapi.padrinho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PadrinhoRepository extends JpaRepository<Padrinho, Long> {


    Optional<Padrinho> findbyName(String nome);

    @Modifying
    @Query(value = "update Padrinho u set u.nome = :where u.id = :id")
    void updateNome(@Param("nome") String nome, @Param("id") Long id);

    default void delete(Long id) {

    }
}
