package com.JohnJasonFisher.kid.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto generate an id.
    private Long id;

    @Column(name="title")
    @NotBlank
    private String title;

    @Column(name="description")
    @NotBlank
    private String description;

    @Column(name="release_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date release_date;

    public Game(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
