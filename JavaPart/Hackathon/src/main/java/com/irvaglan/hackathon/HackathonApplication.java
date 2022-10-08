package com.irvaglan.hackathon;

import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Entity.NLP;
import com.irvaglan.hackathon.Repository.HeadlineRepository;
import com.irvaglan.hackathon.Repository.NLPRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(NLPRepository nlpRepository, HeadlineRepository headlineRepository) {
        return (args -> {
            NLP nlp = new NLP("Not Trendy!", "UnInsightful", "Back-End Developer");
            Headline headline = new Headline("Cars 3 and KFC", "Cars 3 and KFC are saving people from depression",
                    "https://vk.com/mrsadpepe");
            nlpRepository.save(nlp);
            headlineRepository.save(headline);
            nlp.setHeadline(headline);
            headline.setNlp(nlp);
            nlpRepository.save(nlp);
            headlineRepository.save(headline);
        });
    }
}
