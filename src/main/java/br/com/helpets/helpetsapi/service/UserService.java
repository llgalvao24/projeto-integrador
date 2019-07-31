package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.dto.UserDTO;
import br.com.helpets.helpetsapi.dto.UserNewDTO;
import br.com.helpets.helpetsapi.model.Address;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.repository.UserRepository;
import br.com.helpets.helpetsapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //encriptar senha
    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    UserRepository repo;

    public User find(Long id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + User.class.getName() ));
    }

    @Transactional
    public User insert(User obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public User update(User obj) {
        User newObj = find(obj.getId()); //verify if obj exists
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    //update logic
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), null, null, objDto.getFirstName(), objDto.getLastName(),
                objDto.getEmail(), null, objDto.getBirthDate(), objDto.getPhone(),
                objDto.getImageUrl(), objDto.getFrequency());
    }

    //overloading in order to create a new obj using dto logic - insert method
    public User fromDTO(UserNewDTO objDto){
        User user = new User(null, objDto.getUsername(), pe.encode(objDto.getPassword()), objDto.getFirstName(), objDto.getLastName(),
                objDto.getEmail(), objDto.getCpf(), objDto.getBirthDate(),
                objDto.getPhone(), objDto.getImageUrl(), objDto.getFrequency());
        Address address = new Address(objDto.getStreetName(), objDto.getStreetNumber(), objDto.getReference(), objDto.getNeighbourhood(),
                objDto.getZipCode(), objDto.getCity(), objDto.getState(), user);
        user.setAddress(address);
        return user;
    }

    private void updateData(User newObj, User obj) {
        newObj.setFirstName(obj.getFirstName());
        newObj.setLastName(obj.getLastName());
        newObj.setEmail(obj.getEmail());
        newObj.setBirthDate(obj.getBirthDate());
        newObj.setPhone(obj.getPhone());
        newObj.setImageUrl(obj.getImageUrl());
    }
}
