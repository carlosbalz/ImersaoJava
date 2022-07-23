import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NasaDataExtractor implements DataExtractor<SpaceImage> {
    public SpaceImage[] getData(String json) {
        try {
            return new ObjectMapper().readValue(json, SpaceImage[].class);
        }
        catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
