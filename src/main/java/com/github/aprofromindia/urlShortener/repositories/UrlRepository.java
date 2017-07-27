package com.github.aprofromindia.urlShortener.repositories;

import com.github.aprofromindia.urlShortener.entities.Url;
import org.springframework.data.repository.Repository;

public interface UrlRepository extends Repository<Url, Long> {
    Url save(Url url);

    Url findByShortUrl(String shortUrl);

    Url deleteByShortUrl(String shortUrl);

    long countByShortUrl(String shortUrl);
}
