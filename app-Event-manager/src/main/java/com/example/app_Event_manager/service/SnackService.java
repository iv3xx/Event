package com.example.app_Event_manager.service;


import com.example.app_Event_manager.model.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SnackService extends CateringService {
    double calculatePerPersonBudget(List<Guest> guests, double remainingBudget);
}

