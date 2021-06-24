package com.example.urlshortener.dto;



//somehow lombok not detecting.so writting setter and getter
public class LongUrlRequest {
    private String fullUrl;

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LongUrlRequest(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LongUrlRequest() {
    }
}
