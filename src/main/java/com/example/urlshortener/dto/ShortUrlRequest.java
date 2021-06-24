package com.example.urlshortener.dto;

//somehow lombok not detecting.so writting setter and getter

public class ShortUrlRequest {
     String shortUrl;

     public String getShortUrl() {
          return shortUrl;
     }

     public void setShortUrl(String shortUrl) {
          this.shortUrl = shortUrl;
     }

     public ShortUrlRequest(String shortUrl) {
          this.shortUrl = shortUrl;
     }

     public ShortUrlRequest() {
     }
}
