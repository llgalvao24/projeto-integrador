package br.com.helpets.helpetsapi.comentario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    /* TODO - Query atualizar comentário por usuário (padrinho)
    @Transactional
    @Modifying
    @Query("UPDATE Comentario c SET c.texto = :texto WHERE c.padrinho = :padrinho")
    void updateComentariobyPadrinho (Padrinho padrinho, String texto);
     */
     
}
