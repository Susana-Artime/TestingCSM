package org.factoriaf5.springboot.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.springboot.models.Country;
import org.factoriaf5.springboot.services.CountryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CountryController.class)
//@AutoConfigureMockMvc(addFilters = false) // to disable security
public class CountryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CountryService service;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Should return a list of countries")
    void testIndex() throws Exception {

        List<Country> countries = new ArrayList<>();
        Country spain = new Country(1L, "Spain");
        Country england = new Country(2L, "England");
        countries.add(spain);
        countries.add(england);

        when(service.getAll()).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries")
            .accept(MediaType.APPLICATION_JSON)
            .content("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

            System.out.println(response.getContentAsString());

            assertThat(response.getStatus(), is(200));
            assertThat(response.getContentAsString(), containsString(spain.getName()));
            assertThat(response.getContentAsString(), containsString(england.getName()));
            assertThat(response.getContentAsString(), equalTo(mapper.writeValueAsString(countries)));

    }
}
