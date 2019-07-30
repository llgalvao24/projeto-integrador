package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.dto.CommentDTO;
import br.com.helpets.helpetsapi.dto.PostDTO;
import br.com.helpets.helpetsapi.model.Comment;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Void> update(@RequestBody CommentDTO objDto, @PathVariable Long id){
        Comment obj = service.fromDTO(objDto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    //deletes an object by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //gets all objs using a ObjDTO
    @GetMapping("")
    public ResponseEntity<List<CommentDTO>> findAll() {
        List<Comment> list = service.findAll();
        List<CommentDTO> listDto = list.stream().map(CommentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //pagination with optional param in requisition - 24 -> 2, 3, 4, 6
    @GetMapping("/page")
    public ResponseEntity<Page<CommentDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="commData") String orderBy, //class attribute
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Comment> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<CommentDTO> listDto = list.map(CommentDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}
