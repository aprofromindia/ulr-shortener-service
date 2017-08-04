package com.github.aprofromindia.urlShortener.services;

import com.github.aprofromindia.urlShortener.entities.Url;
import com.github.aprofromindia.urlShortener.errors.Error;
import com.github.aprofromindia.urlShortener.errors.UrlException;
import com.github.aprofromindia.urlShortener.repositories.UrlRepository;
import com.github.aprofromindia.urlShortener.utils.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
public class UrlWriteServiceImpl implements UrlWriteService {
    private final UrlRepository repository;

    @Override
    public String createShortUrl(String address) {
        Url url = new Url(address, getHash(address));
        if ((url = repository.save(url)) != null) {
            return url.getShortUrl();
        } else throw new UrlException(Error.REQ_BODY_ERROR, "Failed to persist url.");
    }


    @CacheEvict("urlId")
    @Override
    public void deleteShortUrl(String shortUrl) {
        repository.deleteById(UrlUtils.decode(shortUrl));
    }

    private String getHash(@NotNull String urlAddress) {
        return DigestUtils.md5DigestAsHex(urlAddress.getBytes());
    }
}
