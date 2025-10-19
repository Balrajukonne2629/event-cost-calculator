package com.eventcalculator.controller;

import com.eventcalculator.model.CalculationRequest;
import com.eventcalculator.model.CalculationResult;
import com.eventcalculator.service.EventCostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    
    @Autowired
    private EventCostService eventCostService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("calculationRequest", new CalculationRequest());
        return "index";
    }
    
    @PostMapping("/calculate")
    public String calculate(@Valid @ModelAttribute("calculationRequest") CalculationRequest request,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        
        try {
            CalculationResult result = eventCostService.calculateEventCost(request);
            model.addAttribute("result", result);
            model.addAttribute("service", eventCostService);
            model.addAttribute("calculationRequest", request);
            return "index";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}
