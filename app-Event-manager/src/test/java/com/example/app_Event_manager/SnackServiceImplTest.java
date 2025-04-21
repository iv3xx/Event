package com.example.app_Event_manager;

import com.example.app_Event_manager.service.SnackServiceImpl;
import com.example.app_Event_manager.model.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnackServiceImplTest {

    private SnackServiceImpl snackService;

    @BeforeEach
    void setUp() {
        snackService = new SnackServiceImpl();
    }

    @Test
    void testCalculateTotalCost_withSufficientBudget() {
        List<Guest> guests = List.of(new Guest(), new Guest(), new Guest()); // 3 гостя
        double remainingBudget = 10000.0;

        double result = snackService.calculateTotalCost(guests, remainingBudget);

        assertEquals(7500.0, result); // 3 * 2500
    }

    @Test
    void testCalculateTotalCost_withLimitedBudget() {
        List<Guest> guests = List.of(new Guest(), new Guest(), new Guest()); // 3 гостя
        double remainingBudget = 5000.0;

        double result = snackService.calculateTotalCost(guests, remainingBudget);

        assertEquals(5000.0, result); // меньше, чем 7500 — возвращает бюджет
    }

    @Test
    void testCalculateTotalCost_withNoGuests() {
        List<Guest> guests = List.of();
        double remainingBudget = 10000.0;

        double result = snackService.calculateTotalCost(guests, remainingBudget);

        assertEquals(0.0, result); // по нулям
    }

    @Test
    void testCalculatePerPersonBudget_withGuests() {
        List<Guest> guests = List.of(new Guest(), new Guest(), new Guest()); // 3 гостя
        double remainingBudget = 9000.0;

        double result = snackService.calculatePerPersonBudget(guests, remainingBudget);

        assertEquals(3000.0, result);
    }

    @Test
    void testCalculatePerPersonBudget_withNoGuests() {
        List<Guest> guests = List.of(); // 0 гостей
        double remainingBudget = 9000.0;

        double result = snackService.calculatePerPersonBudget(guests, remainingBudget);

        assertEquals(0.0, result); // деление на 0
    }
}
