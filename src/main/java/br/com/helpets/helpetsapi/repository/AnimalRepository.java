package br.com.helpets.helpetsapi.repository;

import br.com.helpets.helpetsapi.dto.UserDTO;
import br.com.helpets.helpetsapi.model.Animal;
import br.com.helpets.helpetsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "update Animal u set u.animalName= :animalName where u.id = :id")
//    void updateName(@Param("animalName") String animalName, @Param("id") Long id);


    List<Animal> findAnimalsByUser(User user);
}
