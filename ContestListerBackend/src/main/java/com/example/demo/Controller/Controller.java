package com.example.demo.Controller;


import com.example.demo.Models.Contest;
import com.example.demo.Models.Hackathon;
import com.example.demo.Models.Hiring;
import com.example.demo.dao.ContestRepo;
import com.example.demo.dao.HackathonRepo;
import com.example.demo.dao.HiringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private  final HiringRepo hiringLists ;
    private  final ContestRepo contestRepo;
    private final HackathonRepo hackathonRepo;
    private final HiringRepo hiringRepo;

    @Autowired
    public Controller(HiringRepo hiringLists, ContestRepo contestRepo, HackathonRepo hackathonRepo, HiringRepo hiringRepo) {
        this.hiringLists = hiringLists;
        this.contestRepo = contestRepo;
        this.hackathonRepo = hackathonRepo;
        this.hiringRepo = hiringRepo;
    }

    @GetMapping("/api/hiring")
    public List<Hiring> getHiring(){
       return hiringRepo.findAll();
    }

    @GetMapping("/api/contest")
    public List<Contest> getContest(){
        return contestRepo.findAll();
    }
    @GetMapping("/api/hackathon")
    public List<Hackathon> getHackathon(){
        return hackathonRepo.findAll();
    }
}
    