package com.github.aprofromindia.urlShortener.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@EqualsAndHashCode(of = "id")
@Getter
public class Url {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String address;

    @Column(nullable = false, unique = true, name = "short_url")
    private String shortUrl;

    public Url(String address, String shortUrl) {
        this.address = address;
        this.shortUrl = shortUrl;
    }
}
