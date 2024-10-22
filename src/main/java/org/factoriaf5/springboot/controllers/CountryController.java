package org.factoriaf5.springboot.controllers;

import java.util.List;

import org.factoriaf5.springboot.models.Country;
import org.factoriaf5.springboot.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    
    private CountryService services;
    
    public CountryController(CountryService services) {
        this.services = services;
    }

    @GetMapping( path = "/countries")
    public List<Country> index() {
        
        return services.getAll();
    }
}
