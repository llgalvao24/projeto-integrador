package br.com.helpets.helpetsapi.repository;


import br.com.helpets.helpetsapi.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    /* TODO - Query atualizar comentário por usuário (padrinho)
    @Transactional
    @Modifying
    @Query("UPDATE Comentario c SET c.texto = :texto WHERE c.padrinho = :padrinho")
    void updateComentariobyPadrinho (Padrinho padrinho, String texto);
     */
     
}