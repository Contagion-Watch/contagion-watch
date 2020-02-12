package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {

}
