package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Animal;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/{id}")
    public ResponseEntity<Animal> find(@PathVariable(value = "id") Long id) {
        Animal obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    //creates a new obj
    @PostMapping("")
    public ResponseEntity<Void> insert(@RequestBody Animal obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri(); //return uri (id) created obj
        return ResponseEntity.created(uri).build();
    }
}
