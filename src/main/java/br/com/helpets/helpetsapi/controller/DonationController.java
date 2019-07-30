package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Donation;
import br.com.helpets.helpetsapi.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {

    @Autowired
    private DonationService service;

    //gets an obj by id
    @GetMapping("/{id}")
    public ResponseEntity<Donation> find(@PathVariable Long id) {
        Donation obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    //creates a new obj
    @PostMapping("")
    public ResponseEntity<Void> insert (@RequestBody Donation obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri(); //return uri (id) created obj
        return ResponseEntity.created(uri).build();
    }

    //updates an obj by id
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Donation obj, @PathVariable Long id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    //deletes an object by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}


