package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Location;
import com.contagionwatch.contagionwatch.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
