package com.example.app_Event_manager.model;

public class BudgetCalculationResult {
    private double venueAmount;
    private double decorAmount;
    private double photoVideoAmount;
    private double showTechAmount;
    private double printingAmount;
    private double transportAmount;
    private double attireAmount;

    public BudgetCalculationResult(double venueAmount, double decorAmount, double photoVideoAmount, double showTechAmount,
                                   double printingAmount, double transportAmount, double attireAmount) {
        this.venueAmount = venueAmount;
        this.decorAmount = decorAmount;
        this.photoVideoAmount = photoVideoAmount;
        this.showTechAmount = showTechAmount;
        this.printingAmount = printingAmount;
        this.transportAmount = transportAmount;
        this.attireAmount = attireAmount;
    }

    public double getVenueAmount() {
        return venueAmount;
    }

    public void setVenueAmount(double venueAmount) {
        this.venueAmount = venueAmount;
    }

    public double getDecorAmount() {
        return decorAmount;
    }

    public void setDecorAmount(double decorAmount) {
        this.decorAmount = decorAmount;
    }

    public double getPhotoVideoAmount() {
        return photoVideoAmount;
    }

    public void setPhotoVideoAmount(double photoVideoAmount) {
        this.photoVideoAmount = photoVideoAmount;
    }

    public double getShowTechAmount() {
        return showTechAmount;
    }

    public void setShowTechAmount(double showTechAmount) {
        this.showTechAmount = showTechAmount;
    }

    public double getPrintingAmount() {
        return printingAmount;
    }

    public void setPrintingAmount(double printingAmount) {
        this.printingAmount = printingAmount;
    }

    public double getTransportAmount() {
        return transportAmount;
    }

    public void setTransportAmount(double transportAmount) {
        this.transportAmount = transportAmount;
    }

    public double getAttireAmount() {
        return attireAmount;
    }

    public void setAttireAmount(double attireAmount) {
        this.attireAmount = attireAmount;
    }

}
