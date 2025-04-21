package com.example.app_Event_manager;

import com.example.app_Event_manager.model.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.app_Event_manager.service.BudgetFacade;
import com.example.app_Event_manager.service.AlcoholService;
import com.example.app_Event_manager.service.DessertService;
import com.example.app_Event_manager.service.SnackService;
import com.example.app_Event_manager.service.AlcoholCalculationResult;
import com.example.app_Event_manager.service.FullBudgetCalculationResult;

import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BudgetFacadeTest {

    private AlcoholService alcoholService;
    private DessertService dessertService;
    private SnackService snackService;
    private BudgetFacade budgetFacade;

    @BeforeEach
    void setUp() {
        alcoholService = mock(AlcoholService.class);
        dessertService = mock(DessertService.class);
        snackService = mock(SnackService.class);
        budgetFacade = new BudgetFacade(alcoholService, dessertService, snackService);
    }

    @Test
    void testCalculateFullBudget() {
        // Arrange
        List<Guest> guests = List.of(new Guest(), new Guest());
        double totalBudget = 10000.0;

        double expectedVenueBudget = totalBudget * 0.35;
        double alcoholBudget = expectedVenueBudget * 0.4;
        double dessertBudget = expectedVenueBudget * 0.2;
        double snackBudget = expectedVenueBudget * 0.4;

        AlcoholCalculationResult mockAlcoholResult = mock(AlcoholCalculationResult.class);
        when(alcoholService.calculateAlcoholDistribution(guests, alcoholBudget)).thenReturn(mockAlcoholResult);
        when(dessertService.calculateTotalCost(guests, dessertBudget)).thenReturn(700.0);
        when(snackService.calculateTotalCost(guests, snackBudget)).thenReturn(1400.0);

        // Act
        FullBudgetCalculationResult result = budgetFacade.calculateFullBudget(guests, totalBudget);

        // Assert
        assertEquals(totalBudget, result.getTotalBudget(), 0.01);
        assertEquals(expectedVenueBudget, result.getVenueBudget(), 0.01);
        assertEquals(totalBudget * 0.15, result.getDecorBudget(), 0.01);
        assertEquals(totalBudget * 0.10, result.getPhotoVideoBudget(), 0.01);
        assertEquals(totalBudget * 0.20, result.getShowTechBudget(), 0.01);
        assertEquals(totalBudget * 0.03, result.getPrintingBudget(), 0.01);
        assertEquals(totalBudget * 0.05, result.getTransportBudget(), 0.01);
        assertEquals(totalBudget * 0.10, result.getAttireBudget(), 0.01);

        assertSame(mockAlcoholResult, result.getAlcoholCalculation());
        assertEquals(700.0, result.getDessertsCost(), 0.01);
        assertEquals(1400.0, result.getSnacksCost(), 0.01);


        verify(alcoholService).calculateAlcoholDistribution(guests, alcoholBudget);
        verify(dessertService).calculateTotalCost(guests, dessertBudget);
        verify(snackService).calculateTotalCost(guests, snackBudget);
    }

    @Test
    void testCalculateFullBudgetWithEmptyGuestList() {
        List<Guest> emptyGuestList = List.of();
        double totalBudget = 5000.0;

        double expectedVenueBudget = totalBudget * 0.35;
        double alcoholBudget = expectedVenueBudget * 0.4;
        double dessertBudget = expectedVenueBudget * 0.2;
        double snackBudget = expectedVenueBudget * 0.4;

        AlcoholCalculationResult mockAlcoholResult = mock(AlcoholCalculationResult.class);
        when(alcoholService.calculateAlcoholDistribution(emptyGuestList, alcoholBudget)).thenReturn(mockAlcoholResult);
        when(dessertService.calculateTotalCost(emptyGuestList, dessertBudget)).thenReturn(0.0);
        when(snackService.calculateTotalCost(emptyGuestList, snackBudget)).thenReturn(0.0);

        FullBudgetCalculationResult result = budgetFacade.calculateFullBudget(emptyGuestList, totalBudget);

        assertEquals(0.0, result.getDessertsCost(), 0.01);
        assertEquals(0.0, result.getSnacksCost(), 0.01);
        assertSame(mockAlcoholResult, result.getAlcoholCalculation());
    }


    @Test
    void testCalculateFullBudgetWithZeroBudget() {
        List<Guest> guests = List.of(new Guest());
        double totalBudget = 0.0;

        AlcoholCalculationResult mockAlcoholResult = mock(AlcoholCalculationResult.class);
        when(alcoholService.calculateAlcoholDistribution(guests, 0.0)).thenReturn(mockAlcoholResult);
        when(dessertService.calculateTotalCost(guests, 0.0)).thenReturn(0.0);
        when(snackService.calculateTotalCost(guests, 0.0)).thenReturn(0.0);

        FullBudgetCalculationResult result = budgetFacade.calculateFullBudget(guests, totalBudget);

        assertEquals(0.0, result.getTotalBudget(), 0.01);
        assertEquals(0.0, result.getVenueBudget(), 0.01);
        assertEquals(0.0, result.getDecorBudget(), 0.01);
        assertEquals(0.0, result.getPhotoVideoBudget(), 0.01);
        assertEquals(0.0, result.getShowTechBudget(), 0.01);
        assertEquals(0.0, result.getPrintingBudget(), 0.01);
        assertEquals(0.0, result.getTransportBudget(), 0.01);
        assertEquals(0.0, result.getAttireBudget(), 0.01);

        assertSame(mockAlcoholResult, result.getAlcoholCalculation());
        assertEquals(0.0, result.getDessertsCost(), 0.01);
        assertEquals(0.0, result.getSnacksCost(), 0.01);
    }

    @Test
    void testCalculateFullBudgetWithManyGuestsAndTinyBudget() {
        // 100 гостей
        List<Guest> guests = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            guests.add(new Guest());
        }

        double totalBudget = 10.0;  // Крошечный бюджет

        double expectedVenueBudget = totalBudget * 0.35;
        double alcoholBudget = expectedVenueBudget * 0.4;
        double dessertBudget = expectedVenueBudget * 0.2;
        double snackBudget = expectedVenueBudget * 0.4;

        AlcoholCalculationResult mockAlcoholResult = mock(AlcoholCalculationResult.class);
        when(alcoholService.calculateAlcoholDistribution(guests, alcoholBudget)).thenReturn(mockAlcoholResult);
        when(dessertService.calculateTotalCost(guests, dessertBudget)).thenReturn(0.05);
        when(snackService.calculateTotalCost(guests, snackBudget)).thenReturn(0.05);

        FullBudgetCalculationResult result = budgetFacade.calculateFullBudget(guests, totalBudget);

        assertEquals(totalBudget, result.getTotalBudget(), 0.01);
        assertEquals(0.05, result.getDessertsCost(), 0.01);
        assertEquals(0.05, result.getSnacksCost(), 0.01);
        assertSame(mockAlcoholResult, result.getAlcoholCalculation());
    }
}