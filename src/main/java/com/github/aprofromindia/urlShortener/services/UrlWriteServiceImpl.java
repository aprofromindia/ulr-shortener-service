package com.github.aprofromindia.urlShortener.services;

import com.github.aprofromindia.urlShortener.entities.Url;
import com.github.aprofromindia.urlShortener.repositories.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UrlWriteServiceImpl implements UrlWriteService {
    private final UrlRepository repository;

    @Override
    public String generateShortUrl(String address) {
        String shortUrl = "";
        Url url = new Url(address, shortUrl);
        if ((url = repository.save(url)) != null) {
            return url.getShortUrl();
        } else return "";
    }
}
