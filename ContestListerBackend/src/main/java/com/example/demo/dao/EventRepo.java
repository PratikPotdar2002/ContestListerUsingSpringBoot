package com.example.demo.dao;

import com.example.demo.Models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Events,Integer> {

}
