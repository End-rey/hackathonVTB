package com.irvaglan.hackathon.Controller;

import com.irvaglan.hackathon.Entity.Headline;
import com.irvaglan.hackathon.Service.HeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class HeadlineController {

    @Autowired
    private HeadlineService service;

    //GET http://localhost:8080/news
    @GetMapping("/{job}")
    public List<Headline> findAll(@PathVariable String job) {
        return service.findAll(job);
    }
}
