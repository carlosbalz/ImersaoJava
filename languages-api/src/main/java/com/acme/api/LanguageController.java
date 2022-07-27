package com.acme.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
            
    @Autowired
    private LanguageRepository repository;

    @GetMapping("favorite-languages")
    public List<Language> getFavoriteLanguages() {
        var languagesList = repository.findAll();
        return languagesList;
    }

    @PostMapping("favorite-languages")
    public Language postLanguage(@RequestBody Language language) {
        var newLanguage = repository.save(language);
        return newLanguage;
    }
}
