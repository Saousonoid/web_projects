package com.mvc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.app.entity.WebpageEntity;

public interface WebpageRepository extends JpaRepository<WebpageEntity, Long> {

}
