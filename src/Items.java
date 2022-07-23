import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {
    @JsonProperty("items")
    private Movie[] items;    

    @JsonProperty("errorMessage")
    private String errorMessage;

    public Movie[] getItems() {
        return items;
    }
}
