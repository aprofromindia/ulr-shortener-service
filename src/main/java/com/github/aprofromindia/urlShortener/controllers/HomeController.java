package com.github.aprofromindia.urlShortener.controllers;

import com.github.aprofromindia.urlShortener.config.AppConstants;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaTypes.HAL_JSON_VALUE)
    Resource<String> getIndex() {
        return new Resource<>("Welcome to the URL shortener service",
//                linkTo(methodOn(UrlController.class).getUrl("urlID"))
//                        .withRel(AppConstants.REL_GET_SHORT_URL),
                linkTo(methodOn(UrlController.class).postUrl(null, ""))
                        .withRel(AppConstants.REL_CREATE_SHORT_URL),
                linkTo(methodOn(UrlController.class).deleteUrl("urlID"))
                        .withRel(AppConstants.REL_DEL_SHORT_URL),
                linkTo(methodOn(HomeController.class).getIndex())
                        .withSelfRel());
    }
}
