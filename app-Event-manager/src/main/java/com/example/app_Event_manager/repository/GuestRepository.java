package com.example.app_Event_manager.repository;

import com.example.app_Event_manager.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {
    Guest findById(UUID id);
}
