package com.example.demo.dao;

import com.example.demo.Models.Hiring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiringRepo extends JpaRepository<Hiring,Integer> {
}
