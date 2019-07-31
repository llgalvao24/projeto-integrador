package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.model.User;
import br.com.helpets.helpetsapi.service.exception.ObjectNotFoundException;
import br.com.helpets.helpetsapi.model.Address;
import br.com.helpets.helpetsapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository repo;

    public Address find(Long id){
        Optional<Address> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Address.class.getName() ));
    }

    public Address update(Address obj) {
        find(obj.getId()); //verify if obj exists
        return repo.save(obj);
    }
}
