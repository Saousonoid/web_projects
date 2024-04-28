package com.mvc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//
import com.mvc.app.entity.ArticleEntity;
//
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
//
}
