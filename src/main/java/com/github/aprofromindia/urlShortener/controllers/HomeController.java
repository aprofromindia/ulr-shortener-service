package com.github.aprofromindia.urlShortener.controllers;

import com.github.aprofromindia.urlShortener.config.AppConstants;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HomeController {

    @GetMapping("/")
    Resource<String> getIndex() {
        return new Resource<>("Welcome to the URL shortener service",
                linkTo(methodOn(UrlController.class).getResource(""))
                        .withRel(AppConstants.REL_GET_SHORT_URL),
                linkTo(methodOn(UrlController.class).postResource(""))
                        .withRel(AppConstants.REL_CREATE_SHORT_URL),
                linkTo(methodOn(HomeController.class).getIndex())
                        .withSelfRel());
    }
}