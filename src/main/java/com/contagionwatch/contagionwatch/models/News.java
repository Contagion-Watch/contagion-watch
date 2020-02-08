package com.contagionwatch.contagionwatch.models;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(nullable = false, columnDefinition = "DATE")
    private java.sql.Date date;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String summary;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageURL;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String link;

    @ManyToOne
    @JoinColumn (name = "disease_id")
    private Disease disease;

    @ManyToOne
    @JoinColumn (name = "location_id")
    private Location location;

    public News(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
