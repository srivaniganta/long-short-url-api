package com.example.urlshortener.repository;

import com.example.urlshortener.model.DomainEntity;
import com.example.urlshortener.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DomainRepository extends JpaRepository<DomainEntity,Long> {
    @Query(value = "SELECT * FROM  domain d WHERE d.full_domain = ?1", nativeQuery = true)
    Optional<DomainEntity>  findByDomain(String fullDomainValue);


}

