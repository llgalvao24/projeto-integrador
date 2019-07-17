package br.com.helpets.helpetsapi.perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {

    List<Perfil> findByNome(String nome);

    @Modifying
    @Query(value = "update Perfil u set u.nome = :nome where u.idPerfil = :idPerfil")
    void updateNome(@Param("nome") String nome, @Param("idPerfil") Long idPerfil);
}
