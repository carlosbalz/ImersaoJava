import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {
    @JsonProperty("items")
    private List<MoviesDTO> items = new ArrayList<MoviesDTO>();

    public List<MoviesDTO> getItems() {
        return items;
    }
    public void setItems(List<MoviesDTO> items) {
        this.items = items;
    }

    @JsonProperty("errorMessage")
    private String errorMessage;
}
