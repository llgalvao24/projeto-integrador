package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.dto.UserDTO;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //gets all objs using a ObjDTO
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
