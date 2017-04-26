package net.sunnary.sunnary.dto;

import net.sunnary.sunnary.model.Content;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ContentSubmissionForm {
    @NotNull
    @Size(max = 255)
    private String name;

    private List<Long> contentIds;

    private String targetUrl;

    @NotNull
    @Size(max = 5)
    private List<String> tags;

    @NotNull
    private Content.Type type;

    public List<Long> getContentIds() {
        return contentIds;
    }

    public void setContentIds(List<Long> contentIds) {
        this.contentIds = contentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Content.Type getType() {
        return type;
    }

    public void setType(Content.Type type) {
        this.type = type;
    }
}
