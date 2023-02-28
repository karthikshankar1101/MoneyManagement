package com.example.project.moneymanagemengt.repository;

import com.example.project.moneymanagemengt.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit,Integer> {
}
