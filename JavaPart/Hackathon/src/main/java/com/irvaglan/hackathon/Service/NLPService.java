package com.irvaglan.hackathon.Service;

import com.irvaglan.hackathon.Entity.NLP;
import com.irvaglan.hackathon.Repository.NLPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NLPService {

    @Autowired
    private NLPRepository repository;

    public List<NLP> findNLPSByJob(String job) throws Exception {
        try {
            if (repository.existsByJob(job)) {
                return repository.findNLPSByJob(job);
            }
            else {
                throw new Exception("There isn't any article for this occupation.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
