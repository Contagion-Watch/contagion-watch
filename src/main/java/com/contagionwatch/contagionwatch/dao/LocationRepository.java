package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query
    Location getLocationById(long id);
    @Query
    Location getLocationByCountry(String country);
}
