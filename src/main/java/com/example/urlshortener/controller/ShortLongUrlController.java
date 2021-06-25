package com.example.urlshortener.controller;

import com.example.urlshortener.dto.LongUrlRequest;
import com.example.urlshortener.dto.ShortUrlRequest;
import com.example.urlshortener.service.URLService;
import com.example.urlshortener.service.UrlServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/")
public class ShortLongUrlController {

    Logger logger = LoggerFactory.getLogger(ShortLongUrlController.class);

  URLService urlService;

    @Autowired
    public ShortLongUrlController(URLService urlService) {
        this.urlService = urlService;
    }


    @PostMapping("/short-url")
    public ResponseEntity<Object> saveLongUrl(@Valid @RequestBody LongUrlRequest longUrlRequest, HttpServletRequest request) {

        ShortUrlRequest requestDto = urlService.getShortUrl(longUrlRequest);
        String shortDomain= urlService.getDomain(longUrlRequest.getFullUrl());
        requestDto.setShortUrl( (shortDomain == null ? "http://localhost:8080/" : shortDomain) + requestDto.getShortUrl());

        logger.debug(String.format("ShortUrl for FullUrl %s is %s", longUrlRequest.getFullUrl(), requestDto.getShortUrl()));

        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public void pullFullUrlThenRedirect(HttpServletResponse response, @PathVariable String shortUrl) {
        try {

            LongUrlRequest requestDto = urlService.getFullUrl(shortUrl.replace("http://localhost:8080/",""));

            logger.info(String.format("Redirecting to %s", requestDto.getFullUrl()));

            response.sendRedirect(requestDto.getFullUrl());
        } catch (NoSuchElementException e) {
            logger.error(String.format("No URL found for %s in the db", shortUrl));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not found", e);
        } catch (IOException e) {
            logger.error("Could not redirect to the full url");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not redirect to the full url", e);
        }
    }

    @GetMapping("/long-url")
    public void pullFullUrl(HttpServletResponse response, @Valid @RequestParam String shortUrl) {
        try {
            LongUrlRequest requestDto = urlService.getFullUrl(shortUrl.replace("http://localhost:8080/",""));
            response.sendRedirect(requestDto.getFullUrl());
        } catch (NoSuchElementException e) {
            logger.error(String.format("No URL found for %s in the db", shortUrl));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not found", e);
        } catch (IOException e) {
            logger.error("Could not redirect to the full url");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not redirect to the full url", e);
        }

    }
}
