package com.contagionwatch.contagionwatch.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String country;
    @ManyToMany(mappedBy = "location")
    private List<Disease> disease;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<News> news;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Entry> entry;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
