package com.mvc.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mvc.app.entity.ArticleEntity;
import com.mvc.app.mapper.ArticleMapper;
import com.mvc.app.model.ArticleModel;
import com.mvc.app.repository.ArticleRepository;

@Service
public class ArticleService {
	
	private final ArticleMapper mapper;
	private final ArticleRepository articleRepo;

	public ArticleService(ArticleMapper articleMapper, ArticleRepository articleRepository) {
		this.mapper = articleMapper;
		this.articleRepo = articleRepository;
	}

	public List<ArticleModel> listArticles() {
		List<ArticleEntity> articles = articleRepo.findAll();
		return articles.stream()
				.map(l -> mapper.entityToDto(l))
				.collect(Collectors.toList());
	}

	public ArticleModel addArticle(ArticleModel article) {
		ArticleEntity created = articleRepo.save(mapper.toEntity(article));
		return mapper.entityToDto(created);

	}

}
