package net.sunnary.sunnary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tag {
    @Id
    @Column(unique = true)
    private String id;

    public Tag(String id) {
        this.id = id;
    }

    public Tag() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
