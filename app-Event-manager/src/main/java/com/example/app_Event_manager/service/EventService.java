package com.example.app_Event_manager.service;

import com.example.app_Event_manager.CreateEventRequest;
import com.example.app_Event_manager.model.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Event createEvent(Event event);
    Event createEvent(CreateEventRequest request);  // <-- добавили
    Optional<Event> getEventById(UUID id);
    List<Event> getAllEvents();
    Optional<Event> updateEvent(UUID id, Event updatedEvent);
    boolean deleteEvent(UUID id);
}
