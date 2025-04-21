package com.example.app_Event_manager;

import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.service.DessertServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DessertServiceImplTest {

    private DessertServiceImpl dessertService;

    @BeforeEach
    void setUp() {
        dessertService = new DessertServiceImpl();
    }

    @Test
    void testCalculateTotalCost() {
        // Arrange
        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest());
        guests.add(new Guest());
        double dessertBudget = 500.0;
        // Ожидаемый результат
        double expectedCost = 2 * 200 / 100 * 150.0; // 2 гостя по 200 грамм, цена за 100 грамм = 150.0

        // Act
        double totalCost = dessertService.calculateTotalCost(guests, dessertBudget);

        // Assert
        assertEquals(expectedCost, totalCost, 0.01); // допускаем небольшую погрешность
    }

    @Test
    void testCalculateTotalWeight() {
        // Arrange
        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest());
        guests.add(new Guest());

        // Ожидаемый результат
        double expectedWeight = 2 * 200;

        // Act
        double totalWeight = dessertService.calculateTotalWeight(guests);

        // Assert
        assertEquals(expectedWeight, totalWeight);
    }
}