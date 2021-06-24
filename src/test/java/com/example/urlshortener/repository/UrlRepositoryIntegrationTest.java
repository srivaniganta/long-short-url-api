package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UrlRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShortenerRepository shortenerRepository;

    @Test
    public void shouldInsertAndGetFullurl() {
        UrlEntity urlEntity = new UrlEntity("http://example.com");
        shortenerRepository.save(urlEntity);

        assertThat(urlEntity.getId(), notNullValue());

        UrlEntity urlEntityFromDb = shortenerRepository.findById(urlEntity.getId()).get();
        assertThat(urlEntityFromDb.getId(), equalTo(urlEntity.getId()));
    }

}