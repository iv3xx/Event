package com.example.app_Event_manager.service;

import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.service.DessertService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DessertServiceImpl implements DessertService {
    private static final int DESSERT_GRAMS_PER_PERSON = 200;
    private static final double PRICE_PER_100G = 150.0;

    @Override
    public double calculateTotalCost(List<Guest> guests, double dessertBudget) {
        int count = guests.size();
        double totalGrams = count * DESSERT_GRAMS_PER_PERSON;
        return (totalGrams / 100.0) * PRICE_PER_100G;
    }

    @Override
    public double calculateTotalWeight(List<Guest> guests) {
        return guests.size() * DESSERT_GRAMS_PER_PERSON;
    }
}
