package com.eventcalculator.service;

import com.eventcalculator.model.CostBreakdown;
import com.eventcalculator.model.CalculationRequest;
import com.eventcalculator.model.CalculationResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventCostService {
    
    private static class PriceRange {
        double min;
        double max;
        
        PriceRange(double min, double max) {
            this.min = min;
            this.max = max;
        }
        
        double getAverage() {
            return (min + max) / 2;
        }
    }
    
    private static class TierPricing {
        PriceRange decorations;
        PriceRange cateringPerPerson;
        PriceRange musicEntertainment;
        PriceRange photography;
        PriceRange venueSetup;
        PriceRange miscellaneous;
        
        TierPricing(PriceRange decorations, PriceRange cateringPerPerson, 
                   PriceRange musicEntertainment, PriceRange photography,
                   PriceRange venueSetup, PriceRange miscellaneous) {
            this.decorations = decorations;
            this.cateringPerPerson = cateringPerPerson;
            this.musicEntertainment = musicEntertainment;
            this.photography = photography;
            this.venueSetup = venueSetup;
            this.miscellaneous = miscellaneous;
        }
    }
    
    private final Map<String, TierPricing> pricingData;
    private final Map<String, Double> eventMultipliers;
    
    public EventCostService() {
        pricingData = new HashMap<>();
        eventMultipliers = new HashMap<>();
        
        pricingData.put("REGULAR", new TierPricing(
            new PriceRange(5000, 15000),
            new PriceRange(300, 500),
            new PriceRange(8000, 15000),
            new PriceRange(10000, 20000),
            new PriceRange(3000, 8000),
            new PriceRange(2000, 5000)
        ));
        
        pricingData.put("PREMIUM", new TierPricing(
            new PriceRange(15000, 35000),
            new PriceRange(500, 800),
            new PriceRange(15000, 30000),
            new PriceRange(20000, 40000),
            new PriceRange(8000, 15000),
            new PriceRange(5000, 10000)
        ));
        
        pricingData.put("DELUXE", new TierPricing(
            new PriceRange(35000, 75000),
            new PriceRange(800, 1500),
            new PriceRange(30000, 60000),
            new PriceRange(40000, 80000),
            new PriceRange(15000, 30000),
            new PriceRange(10000, 20000)
        ));
        
        eventMultipliers.put("BIRTHDAY", 1.0);
        eventMultipliers.put("WEDDING", 1.8);
        eventMultipliers.put("CORPORATE", 1.3);
        eventMultipliers.put("ANNIVERSARY", 1.2);
    }
    
    public CalculationResult calculateEventCost(CalculationRequest request) {
        String tierKey = request.getServiceTier().toUpperCase();
        String eventKey = request.getEventType().toUpperCase();
        
        TierPricing pricing = pricingData.get(tierKey);
        if (pricing == null) {
            throw new IllegalArgumentException("Invalid service tier: " + request.getServiceTier());
        }
        
        Double multiplier = eventMultipliers.get(eventKey);
        if (multiplier == null) {
            throw new IllegalArgumentException("Invalid event type: " + request.getEventType());
        }
        
        int guests = request.getGuests();
        
        double decorations = calculateCost(pricing.decorations, guests);
        double catering = pricing.cateringPerPerson.getAverage() * guests;
        double musicEntertainment = calculateCost(pricing.musicEntertainment, guests);
        double photography = calculateCost(pricing.photography, guests);
        double venueSetup = calculateCost(pricing.venueSetup, guests);
        double miscellaneous = calculateCost(pricing.miscellaneous, guests);
        
        CostBreakdown breakdown = new CostBreakdown(
            decorations, catering, musicEntertainment,
            photography, venueSetup, miscellaneous, multiplier
        );
        
        return new CalculationResult(guests, request.getEventType(), request.getServiceTier(), breakdown);
    }
    
    private double calculateCost(PriceRange range, int guests) {
        double baseCost = range.getAverage();
        
        double guestFactor = 1.0 + ((guests - 100) / 1000.0);
        guestFactor = Math.max(0.8, Math.min(1.3, guestFactor));
        
        return baseCost * guestFactor;
    }
    
    public String formatIndianCurrency(double amount) {
        long intAmount = Math.round(amount);
        String numStr = String.valueOf(intAmount);
        
        if (numStr.length() <= 3) {
            return "₹" + numStr;
        }
        
        StringBuilder result = new StringBuilder();
        int len = numStr.length();
        
        result.append(numStr.substring(len - 3));
        int remaining = len - 3;
        
        while (remaining > 0) {
            int chunkSize = Math.min(2, remaining);
            result.insert(0, ",");
            result.insert(0, numStr.substring(remaining - chunkSize, remaining));
            remaining -= chunkSize;
        }
        
        return "₹" + result.toString();
    }
}
