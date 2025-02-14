package com.contagionwatch.contagionwatch.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String symptoms;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String transmission;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String preventions;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String treatments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="disease_location",
            joinColumns = {@JoinColumn(name="disease_id")},
            inverseJoinColumns = {@JoinColumn(name="location_id")}
    )
    private List<Location> location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease")
    @JsonManagedReference
    private List<Entry> entry;

    public Disease(){
    }

    public Disease(long id, String description, String name, String preventions, String symptoms, String transmission, String treatments){
        this.id = id;
        this.description = description;
        this.name = name;
        this.preventions = preventions;
        this.symptoms = symptoms;
        this.transmission = transmission;
        this.treatments = treatments;
    }

    public Disease(String description, String name, String preventions, String symptoms, String transmission, String treatments){
        this.description = description;
        this.name = name;
        this.preventions = preventions;
        this.symptoms = symptoms;
        this.transmission = transmission;
        this.treatments = treatments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getPreventions() {
        return preventions;
    }

    public void setPreventions(String preventions) {
        this.preventions = preventions;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
