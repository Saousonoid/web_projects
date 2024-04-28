package com.mvc.app.repository;
//
import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.app.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	  Optional<UserEntity> findByEmail(String email);
      Optional<UserEntity> findUserByEmailOrUsername(String email, String username);

}
