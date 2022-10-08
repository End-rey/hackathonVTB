package com.irvaglan.hackathon.Entity;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "nlps")
public class NLP {
    @Id
    @Column(name = "headline_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "headline_id")
    private Headline headline;
    @NotNull
    private String trend;
    @NotNull
    private String insight;
    @NotNull
    private String job;


    public NLP(String trend, String insight, String job) {
        this.trend = trend;
        this.insight = insight;
        this.job = job;
    }
}
