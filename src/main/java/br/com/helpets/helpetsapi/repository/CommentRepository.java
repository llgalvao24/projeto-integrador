package br.com.helpets.helpetsapi.repository;


import br.com.helpets.helpetsapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /* TODO - Query atualizar comentário por usuário (padrinho)

    @Transactional
    @Modifying
    @Query("UPDATE Comment c SET c.content =: content WHERE c.user")

     */
}
