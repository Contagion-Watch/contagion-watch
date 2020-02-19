package com.contagionwatch.contagionwatch.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.awt.print.Pageable;
import java.sql.Date;

@Entity
@Table(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "DATE")
    private java.sql.Date date;
    @Column
    private long totalCases;
    @Column
    private long newCases;
    @Column
    private long totalDeaths;
    @Column
    private long newDeaths;

    @ManyToOne
    @JoinColumn (name = "disease_id")
    @JsonBackReference
    private Disease disease;

    @ManyToOne
    @JoinColumn (name = "location_id")
    private Location location;

    public Entry(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(long totalCases) {
        this.totalCases = totalCases;
    }

    public long getNewCases() {
        return newCases;
    }

    public void setNewCases(long newCases) {
        this.newCases = newCases;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
