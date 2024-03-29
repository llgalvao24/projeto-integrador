package org.generation.brazil.backend.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /* TODO - Query atualizar comentário por usuário (padrinho)
    @Transactional
    @Modifying
    @Query("UPDATE Post c SET c.texto = :texto WHERE c.padrinho = :padrinho")
    void updatePostbyPadrinho (Padrinho padrinho, String texto);
     */
     
}
