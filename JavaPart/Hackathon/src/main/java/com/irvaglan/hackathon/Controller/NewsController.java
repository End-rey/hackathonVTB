package com.irvaglan.hackathon.Controller;

import com.irvaglan.hackathon.DTO.HeadlineDTO;
import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Entity.NLP;
import com.irvaglan.hackathon.Service.NLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/news")
public class NewsController {

//    @Autowired
//    private HeadlineService headlineService;

    @Autowired
    private NLPService nlpService;

    //GET http://localhost:8080/news
    @GetMapping("/{job}")
    public List<HeadlineDTO> findAll(@PathVariable String job) throws Exception{
        return nlpService.findNLPSByJob(job).stream().map(nlp -> new HeadlineDTO(
                nlp.getId(),
                nlp.getHeadline().getName(),
                nlp.getHeadline().getDescription(),
                nlp.getHeadline().getUrl(),
                nlp.getTrend(),
                nlp.getInsight(),
                nlp.getJob()
        )).collect(Collectors.toList());
    }
}
