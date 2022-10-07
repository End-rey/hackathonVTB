package com.irvaglan.hackathon.DTO;

import lombok.Data;

@Data
public class HeadlineDTO {

    private int id;
    private String name;
    private String description;
    private String url;
    private String trend;
    private String insight;
    private String job;

    public HeadlineDTO(int id, String name, String description, String url, String trend, String insight, String job) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.trend = trend;
        this.insight = insight;
        this.job = job;
    }
}
