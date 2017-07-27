package com.github.aprofromindia.urlShortener.controllers;

import com.github.aprofromindia.urlShortener.entities.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final EntityLinks entityLinks;

    @GetMapping(value = "/", produces = MediaTypes.HAL_JSON_VALUE)
    Resource<String> getIndex() {
        return new Resource<>("Welcome to the URL shortener service",
                entityLinks.linkFor(Url.class).withRel("urls"));
    }
}
