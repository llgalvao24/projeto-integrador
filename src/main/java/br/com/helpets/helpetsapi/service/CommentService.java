package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.dto.CommentDTO;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.service.exception.ObjectNotFoundException;
import br.com.helpets.helpetsapi.model.Comment;
import br.com.helpets.helpetsapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository repo;

    public Comment find(Long id){
        Optional<Comment> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Comment.class.getName() ));
    }

    public Comment insert(Comment obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Comment update(Comment obj) {
        Comment newObj = find(obj.getId()); //verify if obj exists
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }

    public List<Comment> findAll() {
        return repo.findAll();
    }

    public Page<Comment> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    //get
    public Comment fromDTO(CommentDTO objDto){
        return new Comment(objDto.getId(), objDto.getContent(), null, null, null);
    }

    private void updateData(Comment newObj, Comment obj) {
        newObj.setContent(obj.getContent());
    }
}
