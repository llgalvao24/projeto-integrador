package org.generation.brazil.backend.animal;

import org.generation.brazil.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "update Animal u set u.animalName= :animalName where u.id = :id")
//    void updateName(@Param("animalName") String animalName, @Param("id") Long id);


    List<Animal> findAnimalsByUser(User user);
}
