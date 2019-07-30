package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Comment;
import br.com.helpets.helpetsapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    //gets an obj by id
    @GetMapping("/{id}")
    public ResponseEntity<Comment> find(@PathVariable Long id) {
        Comment obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    //creates a new obj
    @PostMapping("")
    public ResponseEntity<Void> insert (@RequestBody Comment obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri(); //return uri (id) created obj
        return ResponseEntity.created(uri).build();
    }

    //updates an obj by id
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Comment obj, @PathVariable Long id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
