package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.Donation;
import br.com.helpets.helpetsapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DonationController {

    @Autowired//Força a injeção de dependencia
    private DonationRepository donationRepository;

    @GetMapping("/donations")
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @GetMapping("/donations/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable(value = "id") Long donationId)
            throws ResourceNotFoundException {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("donation not found for this id: " + donationId));
        return ResponseEntity.ok().body(donation);
    }

    @PostMapping("/donations")
    public Donation createDonation(@Valid @RequestBody Donation donation) {
        return donationRepository.save(donation);
    }

    @PutMapping("/donations/{id}")
    public ResponseEntity<Donation> updateDonation(@PathVariable(value = "id") Long donationId,
                                               @Valid @RequestBody Donation donationDetails) throws ResourceNotFoundException {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("donation not found for this id: " + donationId));

        donation.setAccessory(donationDetails.getAccessory());
        donation.setFood(donationDetails.getFood());
        donation.setGroom(donationDetails.getGroom());
        donation.setMedication(donationDetails.getMedication());

        final Donation updatedDonation = donationRepository.save(donation);
        return ResponseEntity.ok(updatedDonation);
    }

    @DeleteMapping("/donations/{id}")
    public Map<String, Boolean> deleteDonation(@PathVariable(value = "id") Long donationId)
            throws ResourceNotFoundException {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("donation not found for this id: " + donationId));

        donationRepository.delete(donation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


