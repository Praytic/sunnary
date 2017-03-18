package net.sunnary.sunnary.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.sunnary.sunnary.dto.ContentSubmissionForm;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String targetUrl;

    @Column(nullable = false)
    private long likeCounter;

    @Column(nullable = false)
    private long viewCounter;

    @JoinTable
    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date submissionDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public Content() {
    }

    public Content(ContentSubmissionForm dto) {
        this.targetUrl = dto.getTargetUrl();
        this.name = dto.getName();
    }

    public void upvote() {
        setLikeCounter(getLikeCounter() + 1);
    }

    public void downvote() {
        setLikeCounter(getLikeCounter() - 1);
    }

    public void view() {
        setViewCounter(getViewCounter() + 1);
    }

    public enum Type {
        ARTICLE,
        TOOL
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

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
