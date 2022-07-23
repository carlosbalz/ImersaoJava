import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiRequester {
    public String getApiJsonReturn(String apiURL) {        
        try {
            URI address = URI.create(apiURL);
            var client = HttpClient.newHttpClient();        
            var request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        }
        catch(IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}