package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.controller.UserController;
import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "User not found for this id: " + id));
    }
}
