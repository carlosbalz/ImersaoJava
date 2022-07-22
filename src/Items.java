import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {
    @JsonProperty("items")
    private List<Movie> items = new ArrayList<Movie>();

    public List<Movie> getItems() {
        return items;
    }
    public void setItems(List<Movie> items) {
        this.items = items;
    }

    @JsonProperty("errorMessage")
    private String errorMessage;
}
