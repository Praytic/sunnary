package net.sunnary.sunnary.dto;

import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.Tag;

import java.util.Set;
import java.util.stream.Collectors;

public class ContentResponseDto {

    private String name;
    private String targetUrl;
    private Set<String> tags;
    private Content.Type type;
    private String description;
    private long viewCounter;
    private long likeCounter;

    public ContentResponseDto() {
    }

    public ContentResponseDto(Content content) {
        this.name = content.getName();
        this.targetUrl = content.getTargetUrl();
        this.tags = content.getTags().stream().map(Tag::getId).collect(Collectors.toSet());
        this.type = content.getType();
        this.description = content.getContentDescription().getDescription();
        this.viewCounter = content.getViewCounter();
        this.likeCounter = content.getLikeCounter();
    }

    public long getViewCounter() {
        return viewCounter;
    }

    public void setViewCounter(long viewCounter) {
        this.viewCounter = viewCounter;
    }

    public long getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(long likeCounter) {
        this.likeCounter = likeCounter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Content.Type getType() {
        return type;
    }

    public void setType(Content.Type type) {
        this.type = type;
    }
}
