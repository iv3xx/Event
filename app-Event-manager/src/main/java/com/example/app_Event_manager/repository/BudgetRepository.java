package com.example.app_Event_manager.repository;

import com.example.app_Event_manager.model.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, String> {
    // Дополнительные методы при необходимости
    Budget findById(UUID id);
}