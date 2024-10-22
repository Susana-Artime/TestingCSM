package org.factoriaf5.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.springboot.models.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    
    @GetMapping( path = "/countries")
    public List<Country> index() {
        
        Country spain = new Country(1L, "Spain");
        Country france = new Country(2L, "France");

        List<Country> countries = new ArrayList<>();
        countries.add(spain);
        countries.add(france);

        return countries;
    }
}
