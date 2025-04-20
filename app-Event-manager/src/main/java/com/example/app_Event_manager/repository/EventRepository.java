package com.example.app_Event_manager.repository;

import com.example.app_Event_manager.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    // Здесь можно добавить дополнительные методы для поиска по критериям, если необходимо.
    Event findById(UUID id);
}
