//package com.example.app_Event_manager.model;
//import com.example.app_Event_manager.model.enums.EventType;
//
//import java.time.OffsetDateTime;
//import java.time.LocalDate;
//import java.time.OffsetTime;
//import java.util.List;
//import java.util.UUID;
//
//public class Event {
//    private UUID id;
//    private String name;
//    private LocalDate date;
//    private OffsetTime startTime;
//    private OffsetTime endTime;
//    private EventType type;
//    private Budget budget;
//    private DressCode dressCode;
//    private List<Guest> guests;
//    private List<Organizer> organizers;
//
//    public Event() {
//    }
//    public Event(UUID id, String name, LocalDate date, OffsetTime startTime, OffsetTime endTime, EventType type,
//                 Budget budget, DressCode dressCode, List<Guest> guests, List<Organizer> organizers) {
//        this.id = id;
//        this.name = name;
//        this.date = date;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.type = type;
//        this.budget = budget;
//        this.dressCode = dressCode;
//        this.guests = guests;
//        this.organizers = organizers;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public OffsetTime getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime( OffsetTime startTime) {
//        this.startTime = startTime;
//    }
//
//    public  OffsetTime getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime( OffsetTime endTime) {
//        this.endTime = endTime;
//    }
//
//    public EventType getType() {
//        return type;
//    }
//
//    public void setType(EventType type) {
//        this.type = type;
//    }
//
//    public Budget getBudget() {
//        return budget;
//    }
//
//    public void setBudget(Budget budget) {
//        this.budget = budget;
//    }
//
//    public DressCode getDressCode() {
//        return dressCode;
//    }
//
//    public void setDressCode(DressCode dressCode) {
//        this.dressCode = dressCode;
//    }
//
//    public List<Guest> getGuests() {
//        return guests;
//    }
//
//    public void setGuests(List<Guest> guests) {
//        this.guests = guests;
//    }
//
//    public List<Organizer> getOrganizers() {
//        return organizers;
//    }
//
//    public void setOrganizers(List<Organizer> organizers) {
//        this.organizers = organizers;
//    }
//}
package com.example.app_Event_manager.model;
import com.example.app_Event_manager.model.enums.EventType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetTime;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "events")
public class Event {

    @Id
    private String id; // Изменено с UUID на String для MongoDB
    private String name;
    private LocalDate date;
    private OffsetTime startTime;
    private OffsetTime endTime;
    private EventType type;
    private Budget budget;
    private DressCode dressCode;
    private List<Guest> guests;
    private List<Organizer> organizers;

    // Конструкторы, геттеры и сеттеры...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OffsetTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetTime startTime) {
        this.startTime = startTime;
    }

    public OffsetTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetTime endTime) {
        this.endTime = endTime;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public DressCode getDressCode() {
        return dressCode;
    }

    public void setDressCode(DressCode dressCode) {
        this.dressCode = dressCode;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(List<Organizer> organizers) {
        this.organizers = organizers;
    }
}