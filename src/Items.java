import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {
    @JsonProperty("items")
    private Movie[] items;

    public Movie[] getItems() {
        return items;
    }
    public void setItems(Movie[] items) {
        this.items = items;
    }

    @JsonProperty("errorMessage")
    private String errorMessage;
}
