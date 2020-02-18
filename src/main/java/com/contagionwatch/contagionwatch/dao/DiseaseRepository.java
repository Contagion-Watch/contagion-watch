package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    @Query
    Disease getDiseaseById(long id);
}
