package com.example.urlshortener.dto;


import javax.validation.constraints.NotNull;

//somehow lombok not detecting.so writing setter and getter
public class LongUrlRequest {
    @NotNull(message="Full URL Must need")
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
