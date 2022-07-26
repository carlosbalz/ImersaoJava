 import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {
    @JsonProperty("title")
    private String title;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("ranking")
    private int ranking;
        
    public String getTitle() {
        return title;
    }
    public String getIcon() {
        return icon;
    }
    public int getRanking() {
        return ranking;
    }
}
