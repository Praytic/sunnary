package net.sunnary.sunnary.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private URL targetUrl;

    private long likeCounter;

    private long viewCounter;

    @JoinTable(name = "article_tags")
    @ManyToMany
    private Set<Tag> tags;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public URL getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(URL targetUrl) {
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
