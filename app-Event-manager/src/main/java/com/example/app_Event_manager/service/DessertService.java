package com.example.app_Event_manager.service;

import com.example.app_Event_manager.model.Guest;

import java.util.List;


public interface DessertService extends CateringService {
    double calculateTotalWeight(List<Guest> guests); // в граммах
}
