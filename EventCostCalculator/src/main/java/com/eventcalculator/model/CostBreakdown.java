package com.eventcalculator.model;

public class CostBreakdown {
    private double decorations;
    private double catering;
    private double musicEntertainment;
    private double photography;
    private double venueSetup;
    private double miscellaneous;
    private double subtotal;
    private double eventTypeMultiplier;
    private double totalCost;
    
    private double decorationsPercentage;
    private double cateringPercentage;
    private double musicPercentage;
    private double photographyPercentage;
    private double venuePercentage;
    private double miscPercentage;
    
    public CostBreakdown() {}
    
    public CostBreakdown(double decorations, double catering, double musicEntertainment, 
                        double photography, double venueSetup, double miscellaneous,
                        double eventTypeMultiplier) {
        this.decorations = decorations;
        this.catering = catering;
        this.musicEntertainment = musicEntertainment;
        this.photography = photography;
        this.venueSetup = venueSetup;
        this.miscellaneous = miscellaneous;
        this.eventTypeMultiplier = eventTypeMultiplier;
        
        this.subtotal = decorations + catering + musicEntertainment + 
                       photography + venueSetup + miscellaneous;
        this.totalCost = subtotal * eventTypeMultiplier;
        
        calculatePercentages();
    }
    
    private void calculatePercentages() {
        if (totalCost > 0) {
            decorationsPercentage = (decorations * eventTypeMultiplier / totalCost) * 100;
            cateringPercentage = (catering * eventTypeMultiplier / totalCost) * 100;
            musicPercentage = (musicEntertainment * eventTypeMultiplier / totalCost) * 100;
            photographyPercentage = (photography * eventTypeMultiplier / totalCost) * 100;
            venuePercentage = (venueSetup * eventTypeMultiplier / totalCost) * 100;
            miscPercentage = (miscellaneous * eventTypeMultiplier / totalCost) * 100;
        }
    }
    
    public double getDecorations() { return decorations; }
    public void setDecorations(double decorations) { this.decorations = decorations; }
    
    public double getCatering() { return catering; }
    public void setCatering(double catering) { this.catering = catering; }
    
    public double getMusicEntertainment() { return musicEntertainment; }
    public void setMusicEntertainment(double musicEntertainment) { this.musicEntertainment = musicEntertainment; }
    
    public double getPhotography() { return photography; }
    public void setPhotography(double photography) { this.photography = photography; }
    
    public double getVenueSetup() { return venueSetup; }
    public void setVenueSetup(double venueSetup) { this.venueSetup = venueSetup; }
    
    public double getMiscellaneous() { return miscellaneous; }
    public void setMiscellaneous(double miscellaneous) { this.miscellaneous = miscellaneous; }
    
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    
    public double getEventTypeMultiplier() { return eventTypeMultiplier; }
    public void setEventTypeMultiplier(double eventTypeMultiplier) { this.eventTypeMultiplier = eventTypeMultiplier; }
    
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    
    public double getDecorationsPercentage() { return decorationsPercentage; }
    public double getCateringPercentage() { return cateringPercentage; }
    public double getMusicPercentage() { return musicPercentage; }
    public double getPhotographyPercentage() { return photographyPercentage; }
    public double getVenuePercentage() { return venuePercentage; }
    public double getMiscPercentage() { return miscPercentage; }
}
