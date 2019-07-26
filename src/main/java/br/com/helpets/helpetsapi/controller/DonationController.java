package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Donation;
import br.com.helpets.helpetsapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DonationController {

    @Autowired//Força a injeção de dependencia
    private DonationRepository donationRepository;


    // Criar
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/doacao")
    public Donation save(@RequestBody Donation donation){
        return donationRepository.save(donation);// repository é o meud DB.
    }

    // Read
    @GetMapping("/doacao")
    public List<Donation> findAll(){
        return donationRepository.findAll(); //
    }


    //Update com Lambida
    @PutMapping(value="/doacao/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Donation donation) {
        return donationRepository.findById(id)
                .map(record -> {
//                    record.setRacao(donation.getRacao());
//                    record.setBanhoTosa(donation.getBanhoTosa());
//                    record.setMedicamento(donation.getMedicamento());
                    Donation updated = donationRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/doacao/{id}")
    public void delete(@PathVariable Long id){
        donationRepository.deleteById(id);
    }


}


