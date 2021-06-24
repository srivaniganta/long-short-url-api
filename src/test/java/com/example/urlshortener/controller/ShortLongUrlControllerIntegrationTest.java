package com.example.urlshortener.controller;

import com.example.urlshortener.dto.LongUrlRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.urlshortener.service.UrlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ShortLongUrlControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UrlService urlService;


    @Test
    public void givenFullUrlReturnStatusOk() throws Exception {
        LongUrlRequest longUrlRequest = new LongUrlRequest("https://example.com/foo");

        mvc.perform(post("/api/v1/short-url")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(longUrlRequest)))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

}