package com.irvaglan.hackathon.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class NLP {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "headline_id")
    private Headline headline;
    @NotNull
    private String trend;
    @NotNull
    private String insight;
    @NotNull
    private String job;


    public NLP(Headline headline, String trend, String insight, String job) {
        this.headline = headline;
        this.trend = trend;
        this.insight = insight;
        this.job = job;
    }
}
