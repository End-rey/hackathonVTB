package com.irvaglan.hackathon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "nlps")
public class NLP {
    @Id
    @Column(name = "headline_id")
    private int id;

    private String insight;

    private String job;

    private String trend;
    
    @MapsId
    @OneToOne
    @JoinColumn(name = "headline_id")
    private Headline headline;
}