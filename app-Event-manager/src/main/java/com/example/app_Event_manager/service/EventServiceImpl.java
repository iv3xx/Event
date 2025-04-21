////package com.example.app_Event_manager.service;
////
////import com.example.app_Event_manager.CreateEventRequest;
////import com.example.app_Event_manager.model.Budget;
////import com.example.app_Event_manager.model.Event;
////import com.example.app_Event_manager.model.Guest;
////import com.example.app_Event_manager.model.Organizer;
////import org.springframework.stereotype.Service;
////
////import java.util.*;
////
////@Service
////public class EventServiceImpl implements EventService {
////
////    private final Map<UUID, Event> events = new HashMap<>();
////
////    @Override
////    public Event createEvent(Event event) {
////        UUID id = UUID.randomUUID();
////        event.setId(id);
////        events.put(id, event);
////        return event;
////    }
////
////    @Override
////    public Event createEvent(CreateEventRequest request) {
////        Event event = new Event();
////        event.setId(UUID.randomUUID());
////        event.setName(request.getName());
////        event.setBudget(request.getBudget());
////        event.setGuests(request.getGuests());
////        event.setOrganizers(request.getOrganizers());
////        // Можно добавить дефолтные date/startTime/type/dressCode если надо
////        events.put(event.getId(), event);
////        return event;
////    }
////
////    @Override
////    public Optional<Event> getEventById(UUID id) {
////        return Optional.ofNullable(events.get(id));
////    }
////
////    @Override
////    public List<Event> getAllEvents() {
////        return new ArrayList<>(events.values());
////    }
////
////    @Override
////    public Optional<Event> updateEvent(UUID id, Event updatedEvent) {
////        if (events.containsKey(id)) {
////            updatedEvent.setId(id);
////            events.put(id, updatedEvent);
////            return Optional.of(updatedEvent);
////        }
////        return Optional.empty();
////    }
////
////    @Override
////    public boolean deleteEvent(UUID id) {
////        return events.remove(id) != null;
////    }
////}
//package com.example.app_Event_manager.service;
//
//import com.example.app_Event_manager.model.Event;
//import com.example.app_Event_manager.repository.EventRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.*;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class EventServiceImpl {
//
//    @Autowired
//    private EventRepository eventRepository;
//
//    public Event createEvent(Event event) {
//        return eventRepository.save(event);
//    }
//
//    public Optional<Event> getEventById(UUID id) {
//        return eventRepository.findById(id.toString());
//    }
//
//    public List<Event> getAllEvents() {
//        return eventRepository.findAll();
//    }
//
//    public boolean deleteEvent(UUID id) {
//        if (eventRepository.existsById(id.toString())) {
//            eventRepository.deleteById(id.toString());
//            return true;
//        }
//        return false;
//    }
//}
package com.example.app_Event_manager.service;

import com.example.app_Event_manager.CreateEventRequest;
import com.example.app_Event_manager.model.Event;
import com.example.app_Event_manager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event createEvent(CreateEventRequest request) {
        Event event = new Event();
        event.setId(UUID.randomUUID().toString()); // Генерация ID в виде строки
        event.setName(request.getName());
        event.setDate(request.getDate());
        event.setStartTime(request.getStartTime());
        event.setEndTime(request.getEndTime());
        event.setType(request.getType());
        event.setBudget(request.getBudget());
        event.setDressCode(request.getDressCode());
        event.setGuests(request.getGuests());
        event.setOrganizers(request.getOrganizers());
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEventById(UUID id) {
        return eventRepository.findById(id.toString());
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> updateEvent(UUID id, Event updatedEvent) {
        if (eventRepository.existsById(id.toString())) {
            updatedEvent.setId(id.toString());
            return Optional.of(eventRepository.save(updatedEvent));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteEvent(UUID id) {
        if (eventRepository.existsById(id.toString())) {
            eventRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}
