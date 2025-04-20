package com.example.app_Event_manager.repository;

import com.example.app_Event_manager.model.Organizer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizerRepository extends MongoRepository<Organizer, String> {
    Organizer findById(UUID id);
}
