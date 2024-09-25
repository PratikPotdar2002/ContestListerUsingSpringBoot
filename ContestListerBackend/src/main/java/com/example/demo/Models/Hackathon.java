package com.example.demo.Models;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Entity
public class Hackathon {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String platform;
    String url;
    LocalDateTime startTime;
    LocalDateTime endTime;
    boolean in24Hours;
    boolean onGoing;

    public Hackathon(Integer id, String name, String platform, String url, LocalDateTime startTime, LocalDateTime endTime, boolean in24Hours, boolean onGoing) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.url = url;
        this.startTime = startTime;
        this.endTime = endTime;
        this.in24Hours = in24Hours;
        this.onGoing = onGoing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static final Logger log = LoggerFactory.getLogger(com.example.demo.Models.Hackathon.class);

    public Hackathon() {
//        log.info("Hackathon table created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isIn24Hours() {
        return in24Hours;
    }

    public void setIn24Hours(boolean in24Hours) {
        this.in24Hours = in24Hours;
    }

    public boolean isOnGoing() {
        return onGoing;
    }

    public void setOnGoing(boolean onGoing) {
        this.onGoing = onGoing;
    }

    @Override
    public String toString() {
        return "Hackathon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", url='" + url + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", in24Hours=" + in24Hours +
                ", onGoing=" + onGoing +
                '}';
    }
}
