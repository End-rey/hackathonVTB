package com.irvaglan.hackathon.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "headlines")
public class Headline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String description;

    private String name;

    private String url;


    // @OneToOne
    // @PrimaryKeyJoinColumn
    // private NLP nlp;

}
