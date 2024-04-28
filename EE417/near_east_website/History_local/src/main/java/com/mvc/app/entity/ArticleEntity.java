package com.mvc.app.entity;

import java.util.Collection;

import javax.persistence.*;
@Table(name = "articles") 
@Entity(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private String tags;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "webpage_id")
    private WebpageEntity webpage;

    // Default constructor
    public ArticleEntity() {}

    // Getters and setters for id, title, body, tags

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    // Getters and setters for user and webpage

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public WebpageEntity getWebpage() {
        return this.webpage;
    }

    public void setWebpage(WebpageEntity webpage) {
        this.webpage = webpage;
    }
    
  
    

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ArticleEntity)) return false;
        final ArticleEntity other = (ArticleEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final UserEntity this$user = this.getUser();
        final UserEntity other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$body = this.getBody();
        final Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) return false;
        final Object this$tags = this.getTags();
        final Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) return false;
        final WebpageEntity this$webpage = this.getWebpage();
        final WebpageEntity other$webpage = other.getWebpage();
        if (this$webpage == null ? other$webpage != null : !this$webpage.equals(other$webpage)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArticleEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final UserEntity $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $body = this.getBody();
        result = result * PRIME + ($body == null ? 43 : $body.hashCode());
        final Object $tags = this.getTags();
        result = result * PRIME + ($tags == null ? 43 : $tags.hashCode());
        final WebpageEntity $webpage = this.getWebpage();
        result = result * PRIME + ($webpage == null ? 43 : $webpage.hashCode());
        return result;
    }

    public String toString() {
        return "ArticleEntity(id=" + this.getId() + ", title=" + this.getTitle() + ", user=" + this.getUser() + ", body=" + this.getBody() + ", tags=" + this.getTags() + ", webpage=" + this.getWebpage() + ")";
    }

}
