package org.factoriaf5.springboot.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.springboot.models.Country;
import org.factoriaf5.springboot.repositories.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {
    // Injectamos en el servicio el mock del repositorio.
    @InjectMocks
    CountryService service;

    @Mock
    CountryRepository repository;

    @BeforeEach
    void setUp() {
        this.service = new CountryService(repository);
    }

    @Test
    void testGetAll() {

        List<Country> countries = new ArrayList<>();
        Country spain = new Country(1L, "Spain");
        Country england = new Country(2L, "England");
        countries.add(spain);
        countries.add(england);

        when(repository.findAll()).thenReturn(countries);
        List<Country> result = service.getAll();

        assertThat(result.size(),equalTo(2));
        assertThat(result.get(0).getName(), equalTo(spain.getName()));
        assertThat(result,  contains(spain,england));
    }
}
