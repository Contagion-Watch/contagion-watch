package com.contagionwatch.contagionwatch.models;
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
    private List<News> news;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease")
    private List<Entry> entry;

    public Disease(){
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
}
