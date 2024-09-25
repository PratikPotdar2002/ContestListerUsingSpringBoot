package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronService {
    private  final DataBaseService dataBaseService;

    @Autowired
    public CronService(DataBaseService dataBaseService){
        this.dataBaseService = dataBaseService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void execute(){
        dataBaseService.addData();
    }
}
