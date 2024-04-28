package com.mvc.app.entity;

import javax.persistence.*;

import lombok.Data;
import java.util.Collection;

@Table(name = "webpages") 
@Entity(name = "webpages")

public class WebpageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int articleCo;
    
    
    
    public WebpageEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getarticleCo() {
        return articleCo;
    }

    public void setarticleCo(int articleCo) {
        this.articleCo = articleCo;
    }

    
    
    
    // Generated toString() method
    @Override
    public String toString() {
        return "WebpageEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articleCo=" + articleCo +
                '}';
    }

    // Generated equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebpageEntity that = (WebpageEntity) o;

        if (articleCo != that.articleCo) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + articleCo;
        return result;
    }
}
