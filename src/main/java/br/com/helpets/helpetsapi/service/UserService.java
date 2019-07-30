package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User find(Long id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "Object not found for this id: " + id + ", Type: " + User.class.getName() ));
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }
}
