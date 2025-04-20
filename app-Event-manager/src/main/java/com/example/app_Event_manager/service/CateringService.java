package com.example.app_Event_manager.service;
import com.example.app_Event_manager.model.Guest;
import java.util.List;

public interface CateringService {
    double calculateTotalCost(List<Guest> guests, double totalBudget);
}
