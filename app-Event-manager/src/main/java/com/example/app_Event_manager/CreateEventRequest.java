package com.example.app_Event_manager;

import com.example.app_Event_manager.model.Budget;
import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.model.Organizer;
import  com.example.app_Event_manager.model.DressCode;
import com.example.app_Event_manager.model.enums.EventType;

import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.List;

public class CreateEventRequest {
    private String name;
    private Budget budget;
    private List<Guest> guests;
    private List<Organizer> organizers;
    private LocalDate date;
    private OffsetTime startTime;
    private OffsetTime endTime;
    private EventType type;
    private DressCode dressCode;



    // Getters
    public String getName() { return name; }
    public LocalDate getDate() { return date; }
    public  OffsetTime getStartTime() { return startTime; }
    public  OffsetTime getEndTime() { return endTime; }
    public EventType getType() { return type; }
    public Budget getBudget() { return budget; }
    public DressCode getDressCode() { return dressCode; }
    public List<Guest> getGuests() { return guests; }
    public List<Organizer> getOrganizers() { return organizers; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setStartTime( OffsetTime startTime) { this.startTime = startTime; }
    public void setEndTime( OffsetTime endTime) { this.endTime = endTime; }
    public void setType(EventType type) { this.type = type; }
    public void setBudget(Budget budget) { this.budget = budget; }
    public void setDressCode(DressCode dressCode) { this.dressCode = dressCode; }
    public void setGuests(List<Guest> guests) { this.guests = guests; }
    public void setOrganizers(List<Organizer> organizers) { this.organizers = organizers; }
}