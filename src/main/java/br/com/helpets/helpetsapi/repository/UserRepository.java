package br.com.helpets.helpetsapi.repository;

import br.com.helpets.helpetsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "update User u set u.nome = :nome where u.id = :id")
    void updateNome(@Param("nome") String nome, @Param("id") Long id);

    User findByNome(String nome);

}
