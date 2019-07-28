package br.com.helpets.helpetsapi.repository;

import br.com.helpets.helpetsapi.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
}
