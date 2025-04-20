package com.example.app_Event_manager.service;


import com.example.app_Event_manager.model.Guest;
import com.example.app_Event_manager.service.AlcoholCalculationResult;
import com.example.app_Event_manager.service.FullBudgetCalculationResult;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetFacade {
    private final AlcoholService alcoholService;
    private final DessertService dessertService;
    private final SnackService snackService;

    public BudgetFacade(AlcoholService alcoholService, DessertService dessertService, SnackService snackService) {
        this.alcoholService = alcoholService;
        this.dessertService = dessertService;
        this.snackService = snackService;
    }

    public FullBudgetCalculationResult calculateFullBudget(List<Guest> guests, double totalBudget) {
        // Примерные проценты по категориям
        double venueBudget = totalBudget * 0.35;
        double decorBudget = totalBudget * 0.15;
        double photoVideoBudget = totalBudget * 0.10;
        double showTechBudget = totalBudget * 0.20;
        double printingBudget = totalBudget * 0.03;
        double transportBudget = totalBudget * 0.05;
        double attireBudget = totalBudget * 0.10;

        // Бюджет на банкетное меню = venueBudget
        double alcoholBudget = venueBudget * 0.4;
        double dessertBudget = venueBudget * 0.2;
        double snackBudget = venueBudget * 0.4;

        // Расчёты
        AlcoholCalculationResult alcohol = alcoholService.calculateAlcoholDistribution(guests, alcoholBudget);
        double dessertsCost = dessertService.calculateTotalCost(guests, dessertBudget);
        double snacksCost = snackService.calculateTotalCost(guests, snackBudget);

        return new FullBudgetCalculationResult(
                totalBudget,
                venueBudget, decorBudget, photoVideoBudget,
                showTechBudget, printingBudget, transportBudget, attireBudget,
                alcohol, dessertsCost, snacksCost
        );
    }
}
