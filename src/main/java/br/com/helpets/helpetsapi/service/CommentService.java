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
    CommentRepository repo;

    public Comment find(Long id){
        Optional<Comment> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Comment.class.getName() ));
    }

    public Comment insert(Comment obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Comment update(Comment obj) {
        find(obj.getId()); //verify if obj exists
        return repo.save(obj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }


}
