package com.acme.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
public class Language {
    @Id
    private String id;
    private String title;
    private String icon;
    private int ranking;
      
    public Language() {
        
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getIcon() {
        return icon;
    }
    public int getRanking() {
        return ranking;
    }

    public Language(String title, String icon, int ranking) {
        this.title = title;
        this.icon = icon;
        this.ranking = ranking;
    }
}
