package net.sunnary.sunnary.model;

import net.sunnary.sunnary.dto.ArticleSubmissionForm;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String targetUrl;

    private long likeCounter;

    private long viewCounter;

    @JoinTable(name = "article_tags")
    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    private String name;

    public Article() {
    }

    public Article(ArticleSubmissionForm dto) {
        this.targetUrl = dto.getTargetUrl();
        this.name = dto.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public long getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(long likeCounter) {
        this.likeCounter = likeCounter;
    }

    public long getViewCounter() {
        return viewCounter;
    }

    public void setViewCounter(long viewCounter) {
        this.viewCounter = viewCounter;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
