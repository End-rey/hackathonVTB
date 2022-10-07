package com.irvaglan.hackathon.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Headline {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String trends;
    @NotNull
    private String insights;
    @NotNull
    private String jobs;

//    public Headline(String name, String description, String trends, String insights, String jobs) {
//        this.name = name;
//        this.description = description;
//        this.trends = trends;
//        this.insights = insights;
//        this.jobs = jobs;
//    }
}
