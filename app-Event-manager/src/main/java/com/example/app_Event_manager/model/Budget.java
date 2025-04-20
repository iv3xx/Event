package com.example.app_Event_manager.model;


public class Budget {

    private double totalAmount;
    private double venuePercentage;
    private double decorPercentage;
    private double photoVideoPercentage;
    private double showTechPercentage;
    private double printingPercentage;
    private double transportPercentage;
    private double attirePercentage;

    public Budget(double totalAmount, double venuePercentage, double decorPercentage, double photoVideoPercentage,
                  double showTechPercentage, double printingPercentage, double transportPercentage, double attirePercentage) {
        this.totalAmount = totalAmount;
        this.venuePercentage = venuePercentage;
        this.decorPercentage = decorPercentage;
        this.photoVideoPercentage = photoVideoPercentage;
        this.showTechPercentage = showTechPercentage;
        this.printingPercentage = printingPercentage;
        this.transportPercentage = transportPercentage;
        this.attirePercentage = attirePercentage;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getVenuePercentage() {
        return venuePercentage;
    }

    public void setVenuePercentage(double venuePercentage) {
        this.venuePercentage = venuePercentage;
    }

    public double getDecorPercentage() {
        return decorPercentage;
    }

    public void setDecorPercentage(double decorPercentage) {
        this.decorPercentage = decorPercentage;
    }

    public double getPhotoVideoPercentage() {
        return photoVideoPercentage;
    }

    public void setPhotoVideoPercentage(double photoVideoPercentage) {
        this.photoVideoPercentage = photoVideoPercentage;
    }

    public double getShowTechPercentage() {
        return showTechPercentage;
    }

    public void setShowTechPercentage(double showTechPercentage) {
        this.showTechPercentage = showTechPercentage;
    }

    public double getPrintingPercentage() {
        return printingPercentage;
    }

    public void setPrintingPercentage(double printingPercentage) {
        this.printingPercentage = printingPercentage;
    }

    public double getTransportPercentage() {
        return transportPercentage;
    }

    public void setTransportPercentage(double transportPercentage) {
        this.transportPercentage = transportPercentage;
    }

    public double getAttirePercentage() {
        return attirePercentage;
    }

    public void setAttirePercentage(double attirePercentage) {
        this.attirePercentage = attirePercentage;
    }
}
