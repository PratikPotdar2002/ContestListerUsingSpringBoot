package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
public class Events {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String site;
    String url;

    //can use
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssXXX")
    LocalDateTime start_time;

    //    @DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssXXX")
    LocalDateTime end_time;
    boolean in24Hours;
    boolean onGoing;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
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
        return "Events{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", url='" + url + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", in24Hours=" + in24Hours +
                ", onGoing=" + onGoing +
                '}';
    }
}
