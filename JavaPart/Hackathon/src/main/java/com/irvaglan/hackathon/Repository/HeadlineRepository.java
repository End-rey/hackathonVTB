package com.irvaglan.hackathon.Repository;

import com.irvaglan.hackathon.Entity.Headline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadlineRepository extends CrudRepository<Headline, Integer> {
    public Headline findById(int id);
}
