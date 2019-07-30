package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repo;

    public Post find(Long id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Post.class.getName() ));
    }

    public Post insert(Post obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Post update(Post obj) {
        find(obj.getId()); //verify if obj exists
        return repo.save(obj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }
}
