package net.sunnary.sunnary.model;

import javax.persistence.*;

@Entity
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
