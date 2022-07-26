import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LanguagesDataExtractor implements DataExtractor<Language> {
    public Language[] getData(String json) {
        try {
            return new ObjectMapper().readValue(json, Language[].class);
        }
        catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
