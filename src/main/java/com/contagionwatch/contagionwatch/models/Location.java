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
    private List<Entry> entry;

    public Location(){
    }

    public Location(long id, String name){
        this.id = id;
        this.country = name;
    }

    public Location(String name){
        this.country = name;
    }

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
