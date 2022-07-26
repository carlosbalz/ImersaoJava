import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    @JsonProperty("id")
    private String id;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("title")
    private String title;

    @JsonProperty("fullTitle")
    private String fullTitle;

    @JsonProperty("year")
    private String year;

    @JsonProperty("image")
    private String image;

    @JsonProperty("crew")
    private String crew; 

    @JsonProperty("imDbRating")
    private String imDbRating;    
    
    @JsonProperty("imDbRatingCount")
    private String imDbRatingCount;     

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }      

    public String getPosterURL() {
        return image;
    }
    
    public String getRating() {
        return imDbRating;
    }
}
