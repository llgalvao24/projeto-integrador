package br.com.helpets.helpetsapi.administrador;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Long> {

    Optional<Administrador> findByID(Long id);

    Optional<Administrador> findByNome(String nome);

}
