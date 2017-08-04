package com.github.aprofromindia.urlShortener.repositories;

import com.github.aprofromindia.urlShortener.entities.Url;
import org.springframework.data.repository.Repository;

public interface UrlRepository extends Repository<Url, Long> {
    Url save(Url url);

    Url findById(long id);

    Url deleteById(long id);

    long countById(long id);
}
