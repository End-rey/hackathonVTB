package com.irvaglan.hackathon.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Headline {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(mappedBy = "headline", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private NLP nlp;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String url;


    public Headline(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }
}
