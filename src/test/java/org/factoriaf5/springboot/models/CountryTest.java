package org.factoriaf5.springboot.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountryTest {

    private Country country;

    @BeforeEach
    void setUp() {
        country = new Country(1L, "France");
    }

    @Test
    void testCountryHas2Attributes() {
        Field[] countryFields = country.getClass().getDeclaredFields();
        assertThat(countryFields.length, is(2));
    }
    
    @Test
    void testCountryGetters() {
        assertThat(country.getId(), is(1L));
        assertThat(country.getName(), is("France"));
    }
    
    
    
}
