package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableSpringDataWebSupport
public interface EntryRepository extends JpaRepository<Entry, Long> {
    @Query
    List<Entry> getAllByDisease_Id(long id);
    @Query
    List<Entry> getAllByDisease_IdAndLocation_Id(long id, long id2);

    Page<Entry> findAllByDisease_Id(long id, Pageable pageable);
    Page<Entry> findAllByLocation_IdAndDisease_Id(long id1, long id2, Pageable pageable);
}
