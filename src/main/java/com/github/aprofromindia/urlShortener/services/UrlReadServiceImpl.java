package com.github.aprofromindia.urlShortener.services;

import com.github.aprofromindia.urlShortener.repositories.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
public class UrlReadServiceImpl implements UrlReadService {

    private final UrlRepository repository;

    @Override
    public String getUrl(@NotNull String urlId) {
        return repository.findByAddress(urlId).getShortUrl();
    }
}
