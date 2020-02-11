package com.contagionwatch.contagionwatch.models;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "DATE")
    private java.sql.Date date;
    @Column(nullable = false)
    private long totalCases;
    @Column(nullable = false)
    private long newCases;
    @Column(nullable = false)
    private long totalDeaths;
    @Column(nullable = false)
    private long newDeaths;

    @ManyToOne
    @JoinColumn (name = "disease_id")
    private Disease disease;

    @ManyToOne
    @JoinColumn (name = "location_id")
    private Location location;

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

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public long getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }
}
