package com.mvc.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.app.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	

}
