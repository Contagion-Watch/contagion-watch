package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    @Query
    List<Entry> getAllByDisease_Id(long id);
    @Query
    List<Entry> getAllByLocation_Id(long id);
    @Query
    List<Entry> getAllByDisease_IdAndLocation_Id(long id, long id2);
}
