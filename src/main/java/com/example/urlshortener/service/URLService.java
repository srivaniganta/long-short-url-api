package com.example.urlshortener.service;

import com.example.urlshortener.dto.LongUrlRequest;
import com.example.urlshortener.dto.ShortUrlRequest;

public interface URLService {

    public LongUrlRequest getFullUrl(String shortenString);
    public ShortUrlRequest getShortUrl(LongUrlRequest longUrlRequest);

}
