package com.mvc.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.app.model.ArticleModel;
import com.mvc.app.service.ArticleService;


@RestController
public class ArticleController {

	private final ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("/articles")
	public ResponseEntity<List<ArticleModel>> listArticles() {
		System.out.println("Passed here");

		return ResponseEntity.ok(articleService.listArticles());

	}

	@PostMapping("/add/article")
	public ResponseEntity<ArticleModel> createArticles(@RequestBody ArticleModel article) {
		
			ArticleModel created = articleService.addArticle(article);
			return ResponseEntity.ok(created);

	}
}