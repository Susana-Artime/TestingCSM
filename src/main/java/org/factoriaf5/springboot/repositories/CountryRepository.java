package org.factoriaf5.springboot.repositories;

import org.factoriaf5.springboot.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long>  {

}
