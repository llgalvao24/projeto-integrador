package br.com.helpets.helpetsapi.padrinho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PadrinhoRepository extends JpaRepository<Padrinho, Long> {

    @Modifying
    @Transactional
    @Query(value = "update Padrinho u set u.email = :email where u.id = :id")
    void updateEmail(@Param("email") String email, @Param("id") Long id);
}
