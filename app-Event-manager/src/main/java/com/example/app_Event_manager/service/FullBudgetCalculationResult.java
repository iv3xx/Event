package com.example.app_Event_manager.service;

public class FullBudgetCalculationResult {
    private final double totalBudget;

    private final double venueBudget;
    private final double decorBudget;
    private final double photoVideoBudget;
    private final double showTechBudget;
    private final double printingBudget;
    private final double transportBudget;
    private final double attireBudget;

    private final AlcoholCalculationResult alcoholCalculation;
    private final double dessertsCost;
    private final double snacksCost;

    public FullBudgetCalculationResult(
            double totalBudget,
            double venueBudget,
            double decorBudget,
            double photoVideoBudget,
            double showTechBudget,
            double printingBudget,
            double transportBudget,
            double attireBudget,
            AlcoholCalculationResult alcoholCalculation,
            double dessertsCost,
            double snacksCost
    ) {
        this.totalBudget = totalBudget;
        this.venueBudget = venueBudget;
        this.decorBudget = decorBudget;
        this.photoVideoBudget = photoVideoBudget;
        this.showTechBudget = showTechBudget;
        this.printingBudget = printingBudget;
        this.transportBudget = transportBudget;
        this.attireBudget = attireBudget;
        this.alcoholCalculation = alcoholCalculation;
        this.dessertsCost = dessertsCost;
        this.snacksCost = snacksCost;
        System.out.println("Получен бюджет: " + totalBudget);
    }


    public double getTotalBudget() { return totalBudget; }
    public double getVenueBudget() { return venueBudget; }
    public double getDecorBudget() { return decorBudget; }
    public double getPhotoVideoBudget() { return photoVideoBudget; }
    public double getShowTechBudget() { return showTechBudget; }
    public double getPrintingBudget() { return printingBudget; }
    public double getTransportBudget() { return transportBudget; }
    public double getAttireBudget() { return attireBudget; }

    public AlcoholCalculationResult getAlcoholCalculation() { return alcoholCalculation; }
    public double getDessertsCost() { return dessertsCost; }
    public double getSnacksCost() { return snacksCost; }


}