package org.generation.brazil.backend.user;

import org.generation.brazil.backend.address.Address;
import org.generation.brazil.backend.exception.myexc.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public BCryptPasswordEncoder pe() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository repo;

    public User find(Long id){
//        //user only access him/herself or adm
//        UserSS user = UserLogService.authenticated();
//        if(user == null || !user.hasRole(Profile.ADMIN) && !id.equals(user.getId())){
//            throw new AuthorizationException("Access denied!!");
//        }

        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + User.class.getName() ));
    }

    @Transactional
    public User insert(User obj) {
        obj.setId(null);
        System.out.println(obj);
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
        return new User(objDto.getId(), null, null, objDto.getName(),
                objDto.getEmail(), null, objDto.getBirthDate(), objDto.getPhone(),
                objDto.getImageUrl(), objDto.getFrequency());
    }

    //overloading in order to create a new obj using dto logic - insert method
    public User fromDTO(UserNewDTO objDto){
        User user = new User(null, objDto.getUsername(), pe.encode(objDto.getPassword()), objDto.getName(),
                objDto.getEmail(), objDto.getCpf(), objDto.getBirthDate(),
                objDto.getPhone(), objDto.getImageUrl(), objDto.getFrequency());
        Address address = new Address(objDto.getStreetName(), objDto.getStreetNumber(), objDto.getReference(), objDto.getNeighbourhood(),
                objDto.getZipCode(), objDto.getCity(), objDto.getState(), user);
        user.setAddress(address);
        return user;
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setBirthDate(obj.getBirthDate());
        newObj.setPhone(obj.getPhone());
        newObj.setImageUrl(obj.getImageUrl());
    }
}
