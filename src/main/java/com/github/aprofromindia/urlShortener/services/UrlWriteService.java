package com.github.aprofromindia.urlShortener.services;

public interface UrlWriteService {
    String createShortUrl(String address);

    void deleteShortUrl(String urlId);
}
