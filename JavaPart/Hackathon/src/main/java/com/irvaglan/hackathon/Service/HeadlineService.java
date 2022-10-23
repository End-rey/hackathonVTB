package com.irvaglan.hackathon.Service;

import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Repository.HeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HeadlineService {

    @Autowired
    private HeadlineRepository repository;

    public List<Headline> findAll(String job) {
        //job related code is omitted(JK I don't have any job-related data, so it is just a placeholder)
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Headline findById(int id) {
        return repository.findById(id);
    }

}
