package net.sunnary.sunnary.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ArticleSubmissionForm {
    @NotNull
    @Size(min = 10, max = 80)
    private String name;

    @NotNull
    @URL
    private String targetUrl;

    @NotNull
    @Size(min = 1, max = 10)
    private List<String> tags;

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
}
