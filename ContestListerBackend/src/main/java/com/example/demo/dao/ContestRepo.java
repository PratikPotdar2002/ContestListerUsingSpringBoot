package com.example.demo.dao;

import com.example.demo.Models.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepo extends JpaRepository<Contest,Integer> {
}
