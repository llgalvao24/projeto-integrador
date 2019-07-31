package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.dto.UserDTO;
import br.com.helpets.helpetsapi.dto.UserNewDTO;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable(value = "id") Long id){
        User obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    //creates a new obj
    @PostMapping("")
    public ResponseEntity<Void> insert (@RequestBody UserNewDTO objDto){
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri(); //return uri (id) created obj
        return ResponseEntity.created(uri).build();
    }

    //updates an obj by id using object DTO logic
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UserDTO objDto, @PathVariable Long id){
        User obj = service.fromDTO(objDto);
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
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //pagination with optional param in requisition - 24 -> 2, 3, 4, 6
    @GetMapping("/page")
    public ResponseEntity<Page<UserDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="firstName") String orderBy, //class attribute
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<User> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<UserDTO> listDto = list.map(UserDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}
