package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.Comment;
import br.com.helpets.helpetsapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment findComment(Long id) {
        Optional<Comment> obj = commentRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "Comment not found for this id: " + id));
    }
}
