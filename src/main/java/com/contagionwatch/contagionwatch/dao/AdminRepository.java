package com.contagionwatch.contagionwatch.dao;

import com.contagionwatch.contagionwatch.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query
    Admin findByUsername(String username);
}
