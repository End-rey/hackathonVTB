package com.irvaglan.hackathon;

import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Repository.HeadlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(HeadlineRepository repository) {
//        return (args -> {
//            repository.save(new Headline("I have pooped myself", "Today at 2:30 I had shat in my pants!!!!", "Trendy", "Insightful", "Data Scientisto", "porno365.wedding"));
//        });
//    }
}
