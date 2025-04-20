package com.example.app_Event_manager.service;


import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.model.enums.Gender;
import com.example.app_Event_manager.service.AlcoholService;
import com.example.app_Event_manager.service.AlcoholCalculationResult;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlcoholServiceImpl implements AlcoholService {

    @Override
    public AlcoholCalculationResult calculateAlcoholDistribution(List<Guest> guests, double budgetForAlcohol) {
        int maleCount = 0;
        int femaleCount = 0;
        int adultsCount = 0;

        for (Guest guest : guests) {
            if (guest.isChild()) continue;
            adultsCount++;
            if (guest.getGender() == Gender.MALE) maleCount++;
            else if (guest.getGender() == Gender.FEMALE) femaleCount++;
        }

        double champagne = adultsCount * 300; // мл
        double whiteWine = femaleCount * (2.0 / 3 * 500) + maleCount * (2.0 / 3 * 400);
        double redWine = femaleCount * (1.0 / 3 * 500) + maleCount * (1.0 / 3 * 400);
        double strongAlcohol = femaleCount * 150 + maleCount * 200;

        return new AlcoholCalculationResult(champagne, whiteWine, redWine, strongAlcohol, budgetForAlcohol);
    }

    @Override
    public double calculateTotalCost(List<Guest> guests, double budgetForAlcohol) {
        return budgetForAlcohol;
    }
}
