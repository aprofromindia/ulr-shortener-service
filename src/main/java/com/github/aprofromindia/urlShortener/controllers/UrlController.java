package com.github.aprofromindia.urlShortener.controllers;

import com.github.aprofromindia.urlShortener.services.UrlReadService;
import com.github.aprofromindia.urlShortener.services.UrlWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RequestMapping("urls")
@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlReadService readService;
    private final UrlWriteService writeService;

    @GetMapping("/{urlId}")
    String getUrl(@PathVariable @NotNull String urlId) {
        return "redirect:" + readService.getUrl(urlId);
    }

    @PostMapping
    HttpEntity<String> postUrl(HttpServletRequest request, @RequestBody @NotNull String address) {
        final String urlHash = writeService.createShortUrl(address);
        return new ResponseEntity<>(String.format("%s/urls/%s", request.getLocalName(), urlHash), HttpStatus.CREATED);
    }

    @DeleteMapping("/{urlId}")
    HttpEntity<String> deleteUrl(@PathVariable @NotNull String urlId) {
        writeService.deleteUrl(urlId);
        return new ResponseEntity<>("resource deleted", HttpStatus.NO_CONTENT);
    }
}
