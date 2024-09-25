package com.example.demo.dao;

import com.example.demo.Models.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepo extends JpaRepository<Hackathon,Integer> {
}
