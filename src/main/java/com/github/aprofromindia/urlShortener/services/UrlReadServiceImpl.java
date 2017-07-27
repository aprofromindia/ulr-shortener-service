package com.github.aprofromindia.urlShortener.services;

import com.github.aprofromindia.urlShortener.errors.Error;
import com.github.aprofromindia.urlShortener.errors.UrlException;
import com.github.aprofromindia.urlShortener.repositories.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
public class UrlReadServiceImpl implements UrlReadService {

    private final UrlRepository repository;

    @CachePut()
    @Override
    public String getUrl(@NotNull String urlId) {
        if (repository.countByShortUrl(urlId) > 0) {
            return repository.findByShortUrl(urlId).getAddress();
        } else throw new UrlException(Error.GENERIC_ERROR, "no matching url");
    }
}
