package br.com.helpets.helpetsapi.repository;

import br.com.helpets.helpetsapi.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
