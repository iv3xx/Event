package com.example.app_Event_manager.service;


import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.service.SnackService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SnackServiceImpl implements SnackService {
    private static final double MIN_PER_PERSON = 2500.0;

    @Override
    public double calculateTotalCost(List<Guest> guests, double remainingBudget) {
        int count = guests.size();
        return Math.min(remainingBudget, count * MIN_PER_PERSON);
    }

    @Override
    public double calculatePerPersonBudget(List<Guest> guests, double remainingBudget) {
        int count = guests.size();
        return count == 0 ? 0 : remainingBudget / count;
    }
}