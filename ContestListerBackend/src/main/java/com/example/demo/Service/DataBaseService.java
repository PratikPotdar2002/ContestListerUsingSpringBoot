package com.example.demo.Service;


import com.example.demo.Models.Contest;
import com.example.demo.Models.Events;
import com.example.demo.Models.Hackathon;
import com.example.demo.Models.Hiring;
import com.example.demo.dao.ContestRepo;
import com.example.demo.dao.EventRepo;
import com.example.demo.dao.HackathonRepo;
import com.example.demo.dao.HiringRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataBaseService {
    private final EventRepo eventRepo;
    private final RestClient restClient;
    private  final ContestRepo contestRepo;
    private  final HackathonRepo hackathonRepo;
    private final HiringRepo hiringRepo;


    public static final Logger log = LoggerFactory.getLogger(com.example.demo.Service.DataBaseService.class);




    public DataBaseService(RestClient.Builder restClientBuilder, EventRepo eventRepo,ContestRepo contestRepo,HackathonRepo hackathonRepo,HiringRepo hiringRepo) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
        this.eventRepo = eventRepo;
        this.contestRepo = contestRepo;
        this.hiringRepo = hiringRepo;
        this.hackathonRepo = hackathonRepo;
    }

    void addData() {
        Events[] eventDataArray = restClient.get()
                .uri("")
                .retrieve()
                .body(Events[].class);
        List<Events> list = Arrays.asList(eventDataArray);
//        System.out.println(list);
        eventRepo.saveAll(list);
        log.info("Data Ingested Successfully");


        List<Contest> contestList = new ArrayList<>();
        List<Hiring> hiringList  = new ArrayList<>();
        List<Hackathon> hackathonList = new ArrayList<>();
        list.forEach(item->{
            if(item.getName().contains("Hiring")){
                Hiring temp = new Hiring(item.getId(),
                        item.getName(),item.getSite(),item.getUrl(),item.getStart_time(),item.getEnd_time(), item.isIn24Hours(), item.isOnGoing()
                );
                hiringList.add(temp);
            }
            else if (item.getName().contains("Hackathon")){
                Hackathon temp = new Hackathon(
                        item.getId(),
                        item.getName(),item.getSite(),item.getUrl(),item.getStart_time(),item.getEnd_time(), item.isIn24Hours(), item.isOnGoing()
                );
                hackathonList.add(temp);
            }
            else{
                Contest temp = new Contest(
                        item.getId(),
                        item.getName(),item.getSite(),item.getUrl(),item.getStart_time(),item.getEnd_time(), item.isIn24Hours(), item.isOnGoing()
                );
                contestList.add(temp);
            }
        });
        contestRepo.saveAll(contestList);
        hiringRepo.saveAll(hiringList);
        hackathonRepo.saveAll(hackathonList);
    }

    /*void seperatEvent(){
        List<Contest> contestList = new ArrayList<>();
        List<Hiring> hiringList  = new ArrayList<>();
        List<Hackathon> hackathonList = new ArrayList<>();
        list.forEach(item->{
            if(item.getName().contains("hiring")){
                hiringList.add(item);
            }
            else if (item.getName().contains("hackathon")){
                hackathonList.add(item);
            }
            else{
                contestList.add(item);
            }
        });
        contestRepo.saveAll(contestList);
        hiringRepo.saveAll(hiringList);
        hackathonRepo.saveAll(hackathonList);
    }*/

}



