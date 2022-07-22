import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class imdbDataExtractor {
    public Movie[] getData(String json) {
        try {
            var moviesContent = new ObjectMapper().readValue(json, Items.class);                    
            return moviesContent.getItems();  
        }
        catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }        
    }
}
