package net.sunnary.sunnary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContentDescription implements Serializable {

    @Id
    @Column(name = "content_id")
    private Long contentId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;

    @Column
    private String description;

    public ContentDescription() {
    }

    public ContentDescription(Content content, String description) {
        this.contentId = content.getId();
        this.content = content;
        this.description = description;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
