package com.mvc.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.app.entity.ArticleEntity;
import com.mvc.app.entity.UserEntity;
import com.mvc.app.entity.WebpageEntity;
import com.mvc.app.model.ArticleModel;
import com.mvc.app.repository.UserRepository;
import com.mvc.app.repository.WebpageRepository;

// this class can be generated 

@Component
public class ArticleMapper {
	private final UserRepository userRepository;
    private final WebpageRepository webpageRepository;
	@Autowired
    public ArticleMapper(UserRepository userRepository, WebpageRepository webpageRepository) {
        this.userRepository = userRepository;
        this.webpageRepository = webpageRepository;
    }

	 public ArticleModel entityToDto(ArticleEntity entity) {
	        if ( entity == null ) {
	            return null;
	        }

	        ArticleModel.ArticleBuilder article = ArticleModel.builder();

	        if ( entity.getTitle() != null ) {
	            article.id( entity.getId() );
	        }
	        article.title( entity.getTitle() );
	        article.body( entity.getBody() );
	        article.tags( entity.getTags() );
	        article.userId( entity.getUser().getId() );
	        article.webpageId( entity.getWebpage().getId());



	        return article.build();
	    }
	 
	 public ArticleEntity toEntity(ArticleModel model) {
		 if ( model == null ) {
	            return null;
	        }

	        ArticleEntity article = new ArticleEntity();

	        article.setId(model.getId() );
	        article.setTitle( model.getTitle() );
	        article.setBody( model.getBody() );
	        article.setTags( model.getTags() );
	       
	        UserEntity user = userRepository.findById(model.getUserId()).orElse(null);
	        WebpageEntity webpage = webpageRepository.findById(model.getWebpageId()).orElse(null);
	        
	        article.setUser(user);
	        article.setWebpage(webpage );

	        
	        return article;
	 }
}
