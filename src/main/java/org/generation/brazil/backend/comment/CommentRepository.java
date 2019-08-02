package org.generation.brazil.backend.comment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /* TODO - Query atualizar comentário por usuário (padrinho)

    @Transactional
    @Modifying
    @Query("UPDATE Comment c SET c.content =: content WHERE c.user")
     */
}
