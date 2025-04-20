package com.example.app_Event_manager.service;

import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.service.AlcoholCalculationResult;

import java.util.List;

public interface AlcoholService extends CateringService {
    AlcoholCalculationResult calculateAlcoholDistribution(List<Guest> guests, double budgetForAlcohol);
}