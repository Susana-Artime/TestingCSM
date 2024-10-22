package org.factoriaf5.springboot.services;

import java.util.List;

import org.factoriaf5.springboot.models.Country;
import org.factoriaf5.springboot.repositories.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    CountryRepository  repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }
    
    public List<Country> getAll() {
        List<Country> countries =  repository.findAll();

        return countries;
}

}