package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public User save(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    // READ
    @GetMapping("/users")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // UPDATE
    @PatchMapping("/users/update/{id}")
    public void updateNome(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName){
        userRepository.updateFirstNameAndLastNameById(id, firstName, lastName);
    }

    // DELETE
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
