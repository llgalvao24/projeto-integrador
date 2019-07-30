package br.com.helpets.helpetsapi.repository;

import br.com.helpets.helpetsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE User u SET u.firstName =: firstName, u.lastName =:lastName WHERE u.id = :id")
//    void updateFirstNameAndLastNameById(@Param("id") Long id,
//                                        @Param("firstName") String firstName,
//                                        @Param("lastName") String lastName );
//
//    User findByNome(String nome);

}
