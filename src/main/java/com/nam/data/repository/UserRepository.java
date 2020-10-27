package com.nam.data.repository;

import com.nam.data.model.NamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<NamUser, Long> {

   NamUser findByUserId(Long userId);

   NamUser findByEmailAndPassword(String email, String password);

}
