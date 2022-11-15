package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    
    public List<Investment> findAllByAmount(int amount);

}
