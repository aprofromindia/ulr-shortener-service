package com.github.aprofromindia.urlShortener.controllers;

import com.github.aprofromindia.urlShortener.services.UrlReadService;
import com.github.aprofromindia.urlShortener.services.UrlWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlReadService readService;
    private final UrlWriteService writeService;

    @GetMapping("/urls/{urlId}")
    String getResource(@PathVariable @NotNull String urlId) {
        return "redirect:" + readService.getUrl(urlId);
    }

    @PostMapping("/urls")
    HttpEntity<String> postResource(@RequestBody @NotNull String address) {
        final String urlHash = writeService.generateShortUrl(address);
        return new ResponseEntity<>(urlHash, HttpStatus.CREATED);
    }
}
