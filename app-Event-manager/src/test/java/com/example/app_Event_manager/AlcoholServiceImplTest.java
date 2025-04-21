package com.example.app_Event_manager;

import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.service.AlcoholServiceImpl;
import com.example.app_Event_manager.service.AlcoholCalculationResult;
import com.example.app_Event_manager.service.AlcoholService;
import com.example.app_Event_manager.model.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlcoholServiceImplTest {

    private AlcoholServiceImpl alcoholService;

    @BeforeEach
    void setUp() {
        alcoholService = new AlcoholServiceImpl(); // Инициализация сервиса перед каждым тестом
    }

    @Test
    void testCalculateAlcoholDistribution_withNoGuests() {
        List<Guest> guests = Arrays.asList(); // Пустой список гостей
        double budgetForAlcohol = 1000.0;

        AlcoholCalculationResult result = alcoholService.calculateAlcoholDistribution(guests, budgetForAlcohol);

        assertEquals(0.0, result.getChampagneMl(), "Champagne amount should be 0 for no guests");
        assertEquals(0.0, result.getWhiteWineMl(), "White wine amount should be 0 for no guests");
        assertEquals(0.0, result.getRedWineMl(), "Red wine amount should be 0 for no guests");
        assertEquals(0.0, result.getStrongAlcoholMl(), "Strong alcohol amount should be 0 for no guests");
        assertEquals(budgetForAlcohol, result.getBudgetUsed(), "Total cost should be equal to the budget");

        assertEquals("0 бутылок по 750 мл", result.getChampagneBottles(), "Champagne bottles should be 0");
        assertEquals("0 бутылок по 750 мл", result.getWhiteWineBottles(), "White wine bottles should be 0");
        assertEquals("0 бутылок по 750 мл", result.getRedWineBottles(), "Red wine bottles should be 0");
        assertEquals("0 бутылок по 750 мл", result.getStrongAlcoholBottles(), "Strong alcohol bottles should be 0");
    }

    @Test
    void testCalculateAlcoholDistribution_withGuests() {
        // Создадим тестовых гостей
        Guest maleGuest = Mockito.mock(Guest.class);
        Mockito.when(maleGuest.isChild()).thenReturn(false);
        Mockito.when(maleGuest.getGender()).thenReturn(Gender.MALE);

        Guest femaleGuest = Mockito.mock(Guest.class);
        Mockito.when(femaleGuest.isChild()).thenReturn(false);
        Mockito.when(femaleGuest.getGender()).thenReturn(Gender.FEMALE);

        Guest childGuest = Mockito.mock(Guest.class);
        Mockito.when(childGuest.isChild()).thenReturn(true);

        List<Guest> guests = Arrays.asList(maleGuest, femaleGuest, childGuest);

        double budgetForAlcohol = 1500.0;

        AlcoholCalculationResult result = alcoholService.calculateAlcoholDistribution(guests, budgetForAlcohol);

        // Проверим, что калькуляция правильная для каждого напитка
        double expectedChampagne = 600.0;  // 2 взрослых = 2 * 300 мл
        double expectedWhiteWine = (2.0 / 3 * 500) + (2.0 / 3 * 400); // 1 женщина и 1 мужчина
        double expectedRedWine = (1.0 / 3 * 500) + (1.0 / 3 * 400);  // 1 женщина и 1 мужчина
        double expectedStrongAlcohol = 150 + 200; // 1 женщина и 1 мужчина

        assertEquals(expectedChampagne, result.getChampagneMl(), "Champagne amount is incorrect");
        assertEquals(expectedWhiteWine, result.getWhiteWineMl(), "White wine amount is incorrect");
        assertEquals(expectedRedWine, result.getRedWineMl(), "Red wine amount is incorrect");
        assertEquals(expectedStrongAlcohol, result.getStrongAlcoholMl(), "Strong alcohol amount is incorrect");
        assertEquals(budgetForAlcohol, result.getBudgetUsed(), "Total cost should be equal to the budget");

        // Проверим правильность формата бутылок
        assertEquals("1 бутылок по 750 мл", result.getChampagneBottles(), "Champagne bottles should be 1");
        assertEquals("1 бутылок по 750 мл", result.getWhiteWineBottles(), "White wine bottles should be 2");
        assertEquals("1 бутылок по 750 мл", result.getRedWineBottles(), "Red wine bottles should be 2");
        assertEquals("1 бутылок по 750 мл", result.getStrongAlcoholBottles(), "Strong alcohol bottles should be 1");
    }

    @Test
    void testCalculateTotalCost() {
        List<Guest> guests = Arrays.asList();  // Пустой список гостей
        double budgetForAlcohol = 1000.0;

        double result = alcoholService.calculateTotalCost(guests, budgetForAlcohol);

        assertEquals(budgetForAlcohol, result, "Total cost should be equal to the budget");
    }
}