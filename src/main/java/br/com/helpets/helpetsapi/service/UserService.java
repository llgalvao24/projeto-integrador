package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.dto.UserDTO;
import br.com.helpets.helpetsapi.dto.UserNewDTO;
import br.com.helpets.helpetsapi.model.Address;
import br.com.helpets.helpetsapi.model.LoginUser;
import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.repository.UserRepository;
import br.com.helpets.helpetsapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User find(Long id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + User.class.getName() ));
    }

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

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getFirstName(), objDto.getLastName(),
                objDto.getEmail(), null, objDto.getBirthDate(), objDto.getPhone(),
                objDto.getImageUrl(), objDto.getFrequency());
    }

    //overloading in order to create a new obj using dto logic
    public User fromDTO(UserNewDTO objDto){
        User user = new User(null, objDto.getFirstName(), objDto.getLastName(),
                objDto.getEmail(), objDto.getCpf(), objDto.getBirthDate(),
                objDto.getPhone(), objDto.getImageUrl(), objDto.getFrequency());
        Address address = new Address(objDto.getStreetName(), objDto.getStreetNumber(), objDto.getReference(), objDto.getNeighbourhood(),
                objDto.getZipCode(), objDto.getCity(), objDto.getState(), user);
        LoginUser lg = new LoginUser(objDto.getUsername(), objDto.getPassword(), user);
        user.setAddress(address);
        user.setLoginUser(lg);
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
