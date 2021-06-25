package com.example.urlshortener.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "url")
@Table(name = "url")
public class UrlEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "created_on", updatable = false)
    private Timestamp createdOn;


    public UrlEntity() {
    }

    public UrlEntity(Long id, String fullUrl) {
        this.id = id;
        this.fullUrl = fullUrl;
    }

    public UrlEntity(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", fullUrl='" + fullUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
