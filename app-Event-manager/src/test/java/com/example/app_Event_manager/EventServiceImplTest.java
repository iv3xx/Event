package com.example.app_Event_manager;

import com.example.app_Event_manager.CreateEventRequest;
import com.example.app_Event_manager.service.EventService;

import com.example.app_Event_manager.service.EventServiceImpl;
import com.example.app_Event_manager.dto.EventSummaryDTO;

import com.example.app_Event_manager.model.Event;
import com.example.app_Event_manager.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event;
    private CreateEventRequest request;

    @BeforeEach
    void setUp() {
        event = new Event();
        event.setId(UUID.randomUUID().toString());
        event.setName("Event 1");


        request = new CreateEventRequest();
        request.setName("Event 1");

    }

    @Test
    void createEventWithEventObject() {
        when(eventRepository.save(event)).thenReturn(event);

        Event createdEvent = eventService.createEvent(event);

        assertNotNull(createdEvent);
        assertEquals(event.getId(), createdEvent.getId());
        assertEquals(event.getName(), createdEvent.getName());

        verify(eventRepository, times(1)).save(event);
    }

    @Test
    void createEventWithCreateEventRequest() {
        when(eventRepository.save(any(Event.class))).thenReturn(event);

        Event createdEvent = eventService.createEvent(request);

        assertNotNull(createdEvent);
        assertEquals(request.getName(), createdEvent.getName());
        assertEquals(request.getType(), createdEvent.getType());

        verify(eventRepository, times(1)).save(any(Event.class));
    }

    @Test
    void getEventById() {
        when(eventRepository.findById(event.getId())).thenReturn(Optional.of(event));

        Optional<Event> foundEvent = eventService.getEventById(UUID.fromString(event.getId()));

        assertTrue(foundEvent.isPresent());
        assertEquals(event.getId(), foundEvent.get().getId());

        verify(eventRepository, times(1)).findById(event.getId());
    }

    @Test
    void getAllEvents() {
        List<Event> eventsList = Arrays.asList(event);
        when(eventRepository.findAll()).thenReturn(eventsList);

        List<Event> allEvents = eventService.getAllEvents();

        assertNotNull(allEvents);
        assertFalse(allEvents.isEmpty());
        assertEquals(1, allEvents.size());

        verify(eventRepository, times(1)).findAll();
    }

    @Test
    void updateEvent() {
        Event updatedEvent = new Event();
        updatedEvent.setId(event.getId());
        updatedEvent.setName("Updated Event");

        when(eventRepository.existsById(event.getId())).thenReturn(true);
        when(eventRepository.save(updatedEvent)).thenReturn(updatedEvent);

        Optional<Event> result = eventService.updateEvent(UUID.fromString(event.getId()), updatedEvent);

        assertTrue(result.isPresent());
        assertEquals(updatedEvent.getName(), result.get().getName());

        verify(eventRepository, times(1)).save(updatedEvent);
        verify(eventRepository, times(1)).existsById(event.getId());
    }

    @Test
    void deleteEvent() {
        when(eventRepository.existsById(event.getId())).thenReturn(true);

        boolean isDeleted = eventService.deleteEvent(UUID.fromString(event.getId()));

        assertTrue(isDeleted);
        verify(eventRepository, times(1)).deleteById(event.getId());
    }

    @Test
    void deleteEventNotFound() {
        when(eventRepository.existsById(event.getId())).thenReturn(false);

        boolean isDeleted = eventService.deleteEvent(UUID.fromString(event.getId()));

        assertFalse(isDeleted);
        verify(eventRepository, times(0)).deleteById(event.getId());
    }
}