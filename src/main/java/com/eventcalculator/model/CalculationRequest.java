package com.eventcalculator.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CalculationRequest {
    @Min(value = 10, message = "Number of guests must be at least 10")
    @Max(value = 500, message = "Number of guests cannot exceed 500")
    private int guests;
    
    @NotBlank(message = "Event type is required")
    private String eventType;
    
    @NotBlank(message = "Service tier is required")
    private String serviceTier;
    
    public CalculationRequest() {}
    
    public CalculationRequest(int guests, String eventType, String serviceTier) {
        this.guests = guests;
        this.eventType = eventType;
        this.serviceTier = serviceTier;
    }
    
    public int getGuests() { return guests; }
    public void setGuests(int guests) { this.guests = guests; }
    
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    
    public String getServiceTier() { return serviceTier; }
    public void setServiceTier(String serviceTier) { this.serviceTier = serviceTier; }
}
