package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.service.exception.ObjectNotFoundException;
import br.com.helpets.helpetsapi.model.Donation;
import br.com.helpets.helpetsapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {

    @Autowired
    DonationRepository repo;

    public Donation find(Long id){
        Optional<Donation> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Donation.class.getName() ));
    }

    public Donation insert(Donation obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Donation update(Donation obj) {
        find(obj.getId()); //verify if obj exists
        return repo.save(obj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }

    public List<Donation> findAll() {
        return repo.findAll();
    }
}
