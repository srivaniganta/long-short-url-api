package com.example.urlshortener.model;

import javax.persistence.*;

@Entity(name = "domain")
@Table(name = "domain")
public class DomainEntity {
    @Column(name = "Id")
    private  Long id;

    @Column(name = "full_domain", unique = true)
    private String fullDomain;

    @Column(name = "short_domain")
    private String shortDomain;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullDomain() {
        return fullDomain;
    }

    public void setFullDomain(String fullDomain) {
        this.fullDomain = fullDomain;
    }

    public String getShortDomain() {
        return shortDomain;
    }

    public void setShortDomain(String shortDomain) {
        this.shortDomain = shortDomain;
    }
}
