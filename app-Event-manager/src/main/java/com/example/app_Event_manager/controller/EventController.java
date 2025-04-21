//package com.example.app_Event_manager.controller;
//
//import com.example.app_Event_manager.CreateEventRequest;
//import com.example.app_Event_manager.dto.DressCodeDTO;
//import com.example.app_Event_manager.dto.EventSummaryDTO;
//import com.example.app_Event_manager.dto.OrganizerDTO;
//import com.example.app_Event_manager.model.Event;
//import com.example.app_Event_manager.model.Organizer;
//import com.example.app_Event_manager.model.DressCode;
//import com.example.app_Event_manager.service.BudgetFacade;
//import com.example.app_Event_manager.service.EventServiceImpl;
//import com.example.app_Event_manager.service.FullBudgetCalculationResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/events")
//public class EventController {
//
//    @Autowired
//    private EventServiceImpl eventService;
//
//    @Autowired
//    private BudgetFacade budgetFacade;
//
//    @PostMapping
//    public Event createEvent(@RequestBody CreateEventRequest request) {
//        Event event = new Event();
//        event.setName(request.getName());
//        event.setDate(request.getDate());
//        event.setStartTime(request.getStartTime());
//        event.setEndTime(request.getEndTime());
//        event.setType(request.getType());
//        event.setBudget(request.getBudget());
//        event.setDressCode(request.getDressCode());
//        event.setGuests(request.getGuests());
//        event.setOrganizers(request.getOrganizers());
//        return eventService.createEvent(event);
//    }
//
//    @GetMapping
//    public List<EventSummaryDTO> getAllEvents() {
//        return eventService.getAllEvents().stream()
//                .map(event -> {
//                    EventSummaryDTO dto = new EventSummaryDTO();
//                    dto.setName(event.getName());
//                    dto.setDate(event.getDate() != null ? event.getDate().toString() : "N/A");
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/{eventId}")
//    public ResponseEntity<Event> getEventById(@PathVariable UUID eventId) {
//        return eventService.getEventById(eventId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/{eventId}/budget")
//    public ResponseEntity<FullBudgetCalculationResult> getBudget(@PathVariable UUID eventId) {
//        return eventService.getEventById(eventId)
//                .map(event -> {
//                    FullBudgetCalculationResult result = budgetFacade.calculateFullBudget(
//                            event.getGuests(),
//                            event.getBudget().getTotalAmount()
//                    );
//                    return ResponseEntity.ok(result);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/{eventId}/dress-code")
//    public ResponseEntity<DressCodeDTO> getDressCode(@PathVariable UUID eventId) {
//        return (ResponseEntity<DressCodeDTO>) eventService.getEventById(eventId)
//                .map(event -> {
//                    DressCode dressCode = event.getDressCode();
//                    if (dressCode == null) return ResponseEntity.notFound().build();
//                    DressCodeDTO dto = new DressCodeDTO();
//                    dto.setType(dressCode.getType());
//                    return ResponseEntity.ok(dto);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/{eventId}/organizers")
//    public ResponseEntity<List<OrganizerDTO>> getOrganizers(@PathVariable UUID eventId) {
//        return eventService.getEventById(eventId)
//                .map(event -> {
//                    List<OrganizerDTO> dtoList = event.getOrganizers().stream()
//                            .map(org -> {
//                                OrganizerDTO dto = new OrganizerDTO();
//                                dto.setName(org.getName());
//                                return dto;
//                            })
//                            .collect(Collectors.toList());
//                    return ResponseEntity.ok(dtoList);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{eventId}")
//    public ResponseEntity<Void> deleteEvent(@PathVariable UUID eventId) {
//        boolean deleted = eventService.deleteEvent(eventId);
//        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//}
package com.example.app_Event_manager.controller;

import com.example.app_Event_manager.CreateEventRequest;
import com.example.app_Event_manager.dto.DressCodeDTO;
import com.example.app_Event_manager.dto.EventSummaryDTO;
import com.example.app_Event_manager.dto.OrganizerDTO;
import com.example.app_Event_manager.model.Event;
import com.example.app_Event_manager.model.DressCode;
import com.example.app_Event_manager.service.BudgetFacade;
import com.example.app_Event_manager.service.EventServiceImpl;
import com.example.app_Event_manager.service.FullBudgetCalculationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private BudgetFacade budgetFacade;

    @PostMapping
    public Event createEvent(@RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }

    @GetMapping
    public List<EventSummaryDTO> getAllEvents() {
        return eventService.getAllEvents().stream()
                .map(event -> {
                    EventSummaryDTO dto = new EventSummaryDTO();
                    dto.setName(event.getName());
                    dto.setDate(event.getDate() != null ? event.getDate().toString() : "N/A");
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable UUID eventId) {
        return eventService.getEventById(eventId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{eventId}/budget")
    public ResponseEntity<FullBudgetCalculationResult> getBudget(@PathVariable UUID eventId) {
        return eventService.getEventById(eventId)
                .map(event -> {
                    FullBudgetCalculationResult result = budgetFacade.calculateFullBudget(
                            event.getGuests(),
                            event.getBudget().getTotalAmount()
                    );
                    return ResponseEntity.ok(result);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{eventId}/dress-code")
    public ResponseEntity<DressCodeDTO> getDressCode(@PathVariable UUID eventId) {
        return eventService.getEventById(eventId)
                .map(event -> {
                    DressCode dressCode = event.getDressCode();
                    if (dressCode == null) {
                        return ResponseEntity.notFound().<DressCodeDTO>build();
                    }
                    DressCodeDTO dto = new DressCodeDTO();
                    dto.setType(dressCode.getType());
                    dto.setComment(dressCode.getComment());
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().<DressCodeDTO>build());
    }




    @GetMapping("/{eventId}/organizers")
    public ResponseEntity<List<OrganizerDTO>> getOrganizers(@PathVariable UUID eventId) {
        return eventService.getEventById(eventId)
                .map(event -> {
                    List<OrganizerDTO> dtoList = event.getOrganizers().stream()
                            .map(org -> {
                                OrganizerDTO dto = new OrganizerDTO();
                                dto.setName(org.getName());
                                return dto;
                            })
                            .collect(Collectors.toList());
                    return ResponseEntity.ok(dtoList);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID eventId) {
        boolean deleted = eventService.deleteEvent(eventId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
