package com.acme.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    
    // private List<Language> favoriteLanguages = List.of(
    //     new Language("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
    //     new Language("C#", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/csharp/csharp_256x256.png", 2),
    //     new Language("Javascript", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/javascript/javascript_256x256.png?raw=true", 3)
    // );
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
