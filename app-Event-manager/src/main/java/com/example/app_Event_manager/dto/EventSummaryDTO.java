package com.example.app_Event_manager.dto;

import com.example.app_Event_manager.model.enums.EventType;
import com.example.app_Event_manager.service.AlcoholCalculationResult;

import java.util.List;

public class EventSummaryDTO {
    private String name;
    private EventType type;
    private String date;
    private String startTime;
    private String endTime;
    private DressCodeDTO dressCode;
    private int maleCount;
    private int femaleCount;
    private int childCount;
    private List<OrganizerDTO> organizers;

    private double totalBudget;
    private double venueBudget;
    private double decorBudget;
    private double photoVideoBudget;
    private double showTechBudget;
    private double printingBudget;
    private double transportBudget;
    private double attireBudget;
    private double dessertsCost;
    private double snacksCost;

    private AlcoholCalculationResult alcoholCalculation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public DressCodeDTO getDressCode() {
        return dressCode;
    }

    public void setDressCode(DressCodeDTO dressCode) {
        this.dressCode = dressCode;
    }

    public int getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(int maleCount) {
        this.maleCount = maleCount;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(int femaleCount) {
        this.femaleCount = femaleCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public List<OrganizerDTO> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(List<OrganizerDTO> organizers) {
        this.organizers = organizers;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getVenueBudget() {
        return venueBudget;
    }

    public void setVenueBudget(double venueBudget) {
        this.venueBudget = venueBudget;
    }

    public double getDecorBudget() {
        return decorBudget;
    }

    public void setDecorBudget(double decorBudget) {
        this.decorBudget = decorBudget;
    }

    public double getPhotoVideoBudget() {
        return photoVideoBudget;
    }

    public void setPhotoVideoBudget(double photoVideoBudget) {
        this.photoVideoBudget = photoVideoBudget;
    }

    public double getShowTechBudget() {
        return showTechBudget;
    }

    public void setShowTechBudget(double showTechBudget) {
        this.showTechBudget = showTechBudget;
    }

    public double getPrintingBudget() {
        return printingBudget;
    }

    public void setPrintingBudget(double printingBudget) {
        this.printingBudget = printingBudget;
    }

    public double getTransportBudget() {
        return transportBudget;
    }

    public void setTransportBudget(double transportBudget) {
        this.transportBudget = transportBudget;
    }

    public double getAttireBudget() {
        return attireBudget;
    }

    public void setAttireBudget(double attireBudget) {
        this.attireBudget = attireBudget;
    }

    public double getDessertsCost() {
        return dessertsCost;
    }

    public void setDessertsCost(double dessertsCost) {
        this.dessertsCost = dessertsCost;
    }

    public double getSnacksCost() {
        return snacksCost;
    }

    public void setSnacksCost(double snacksCost) {
        this.snacksCost = snacksCost;
    }

    public AlcoholCalculationResult getAlcoholCalculation() {
        return alcoholCalculation;
    }

    public void setAlcoholCalculation(AlcoholCalculationResult alcoholCalculation) {
        this.alcoholCalculation = alcoholCalculation;
    }
}
