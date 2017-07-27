package com.github.aprofromindia.urlShortener.services;

public interface UrlWriteService {
    String createShortUrl(String address);

    void deleteUrl(String urlId);
}
