package com.irvaglan.hackathon.Controller;

import com.irvaglan.hackathon.DTO.HeadlineDTO;
import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Entity.NLP;
import com.irvaglan.hackathon.Repository.HeadlineRepository;
import com.irvaglan.hackathon.Service.HeadlineService;
import com.irvaglan.hackathon.Service.NLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private HeadlineService headlineService;

    @Autowired
    private NLPService nlpService;

    // GET http://localhost:8080/news/job/:job&time=
    @GetMapping("/job/{job}")
    public List<HeadlineDTO> findAll(@PathVariable String job, @RequestParam("time") String time) throws Exception{
        return nlpService.findNLPSByJob(job).stream().map(nlp -> new HeadlineDTO(
                nlp.getId(),
                headlineService.findById(nlp.getId()).getName(),
                headlineService.findById(nlp.getId()).getDescription(),
                headlineService.findById(nlp.getId()).getUrl(),
                nlp.getTrend(),
                nlp.getInsight(),
                nlp.getJob()
        )).collect(Collectors.toList());
    }

    //GET http://localhost:8080/news/1
    @GetMapping("/{id}") 
    public Headline findHeadline(@PathVariable int id) {
        return headlineService.findById(id);
    }
}
