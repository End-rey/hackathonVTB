package com.irvaglan.hackathon.Repository;

import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Entity.NLP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NLPRepository  extends CrudRepository<NLP, String> {

    List<NLP> findNLPSByJob(String job);

    boolean existsByJob(String job);

}
