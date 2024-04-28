package com.mvc.app.model;

import java.util.Objects;


public class ArticleModel {

    private int id;
    private String title;
    private String body;
    private String tags;
    private Long userId;
    private Long webpageId;

    // Constructor
    private ArticleModel(int id, String title, String body, String tags, Long userId, Long webpageId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.userId = userId;
        this.webpageId = webpageId;
    }

    // Builder method
    public static ArticleBuilder builder() {
        return new ArticleBuilder();
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWebpageId() {
        return webpageId;
    }

    public void setWebpageId( Long webpageId) {
        this.webpageId = webpageId;
    }

    // Equals and HashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleModel that = (ArticleModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Builder class
    public static class ArticleBuilder {
        private int id;
        private String title;
        private String body;
        private String tags;
        private Long userId;
        private Long webpageId;

        ArticleBuilder() {
        }

        public ArticleBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ArticleBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder body(String body) {
            this.body = body;
            return this;
        }

        public ArticleBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public ArticleBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public ArticleBuilder webpageId(Long webpageId) {
            this.webpageId = webpageId;
            return this;
        }

        public ArticleModel build() {
            return new ArticleModel(id, title, body, tags, userId, webpageId);
        }

        @Override
        public String toString() {
            return "ArticleModel.ArticleBuilder(id=" + id + ", title=" + title + ", body=" + body + ", tags=" + tags + ", userId=" + userId + ", webpageId=" + webpageId + ")";
        }
    }
}
