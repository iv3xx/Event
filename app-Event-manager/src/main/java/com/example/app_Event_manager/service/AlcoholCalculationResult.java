package com.example.app_Event_manager.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlcoholCalculationResult {

    private static final int BOTTLE_VOLUME_ML = 750;

    @JsonProperty("champagne_ml")
    private final double champagneMl;

    @JsonProperty("champagne_bottles")
    private final String champagneBottles;

    @JsonProperty("white_wine_ml")
    private final double whiteWineMl;

    @JsonProperty("white_wine_bottles")
    private final String whiteWineBottles;

    @JsonProperty("red_wine_ml")
    private final double redWineMl;

    @JsonProperty("red_wine_bottles")
    private final String redWineBottles;

    @JsonProperty("strong_alcohol_ml")
    private final double strongAlcoholMl;

    @JsonProperty("strong_alcohol_bottles")
    private final String strongAlcoholBottles;

    @JsonProperty("budget_used")
    private final double budgetUsed;

    public AlcoholCalculationResult(
            double champagneMl,
            double whiteWineMl,
            double redWineMl,
            double strongAlcoholMl,
            double budgetUsed
    ) {
        this.champagneMl = champagneMl;
        this.whiteWineMl = whiteWineMl;
        this.redWineMl = redWineMl;
        this.strongAlcoholMl = strongAlcoholMl;
        this.budgetUsed = budgetUsed;

        this.champagneBottles = formatBottles(champagneMl);
        this.whiteWineBottles = formatBottles(whiteWineMl);
        this.redWineBottles = formatBottles(redWineMl);
        this.strongAlcoholBottles = formatBottles(strongAlcoholMl);
    }

    private String formatBottles(double volume) {
        int bottles = (int) Math.ceil(volume / BOTTLE_VOLUME_ML);
        return String.format("%d бутылок по %d мл", bottles, BOTTLE_VOLUME_ML);
    }

    public double getChampagneMl() { return champagneMl; }
    public String getChampagneBottles() { return champagneBottles; }

    public double getWhiteWineMl() { return whiteWineMl; }
    public String getWhiteWineBottles() { return whiteWineBottles; }

    public double getRedWineMl() { return redWineMl; }
    public String getRedWineBottles() { return redWineBottles; }

    public double getStrongAlcoholMl() { return strongAlcoholMl; }
    public String getStrongAlcoholBottles() { return strongAlcoholBottles; }

    public double getBudgetUsed() { return budgetUsed; }

    @Override
    public String toString() {
        return String.format(
                "Алкоголь:\n - Шампанское: %.0f мл (%s)\n - Белое вино: %.0f мл (%s)\n - Красное вино: %.0f мл (%s)\n - Крепкий алкоголь: %.0f мл (%s)\n - Использовано из бюджета: %.2f ₽",
                champagneMl, champagneBottles,
                whiteWineMl, whiteWineBottles,
                redWineMl, redWineBottles,
                strongAlcoholMl, strongAlcoholBottles,
                budgetUsed
        );
    }
}
