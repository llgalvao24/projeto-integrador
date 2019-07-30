package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.dto.PostDTO;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService service;

    //gets an obj by id
    @GetMapping("/{id}")
    public ResponseEntity<Post> find(@PathVariable(value = "id") Long id) {
        Post obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    //creates a new obj
    @PostMapping("")
    public ResponseEntity<Void> insert(@RequestBody Post obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri(); //return uri (id) created obj
        return ResponseEntity.created(uri).build();
    }

    //updates an obj by id
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Post obj, @PathVariable Long id){
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //gets all objs using a ObjDTO
    @GetMapping("")
    public ResponseEntity<List<PostDTO>> findAll() {
        List<Post> list = service.findAll();
        List<PostDTO> listDto = list.stream().map(PostDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //pagination with optional param in requisition - 24 -> 2, 3, 4, 6
    @GetMapping("/page")
    public ResponseEntity<Page<PostDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="title") String orderBy, //class attribute
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Post> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<PostDTO> listDto = list.map(PostDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}
