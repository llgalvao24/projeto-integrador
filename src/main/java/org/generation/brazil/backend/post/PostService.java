package org.generation.brazil.backend.post;

import org.generation.brazil.backend.exception.myexc.DataIntegrityException;
import org.generation.brazil.backend.exception.myexc.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repo;

    //verify if obj exists and gets it from db
    public Post find(Long id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Post.class.getName() ));
    }

    public Post insert(Post obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Post update(Post obj) {
        Post newObj = find(obj.getId()); //verify if obj exists and gets it from db
        updateData(newObj, obj); //updates only allowed fields
        return repo.save(newObj);
    }

//    public void delete(Long id){
//        find(id);
//        repo.deleteById(id);
//    }

    public void delete(Long id){
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Not possible to exclude a post with Posts");
        }
    }

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Page<Post> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Post fromDTO(PostDTO objDto){
        return new Post(objDto.getId(), objDto.getTitle(), objDto.getPostImage(), objDto.getContent(), objDto.getPostData(), null);
    }

    //logic of allowed fields
    private void updateData(Post newObj, Post obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setPostImage(obj.getPostImage());
        newObj.setContent(obj.getContent());
    }
}
