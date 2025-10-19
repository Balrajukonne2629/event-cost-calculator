package com.eventcalculator.model;

public class CalculationResult {
    private int guests;
    private String eventType;
    private String serviceTier;
    private CostBreakdown costBreakdown;
    
    public CalculationResult() {}
    
    public CalculationResult(int guests, String eventType, String serviceTier, CostBreakdown costBreakdown) {
        this.guests = guests;
        this.eventType = eventType;
        this.serviceTier = serviceTier;
        this.costBreakdown = costBreakdown;
    }
    
    public int getGuests() { return guests; }
    public void setGuests(int guests) { this.guests = guests; }
    
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    
    public String getServiceTier() { return serviceTier; }
    public void setServiceTier(String serviceTier) { this.serviceTier = serviceTier; }
    
    public CostBreakdown getCostBreakdown() { return costBreakdown; }
    public void setCostBreakdown(CostBreakdown costBreakdown) { this.costBreakdown = costBreakdown; }
}
