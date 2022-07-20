import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {    
    public static void main(String[] args) throws Exception {        
        // create a http connection to the public api
        // convert the return json to a list of movies using DTOs
        // then print the extracted data

        String json = returnMoviesListJson();
        ObjectMapper mapper = new ObjectMapper();
        var items = mapper.readValue(json, Items.class);    
        var movies = items.getItems();
            
        for (MoviesDTO movie : movies) {
            System.out.println("Rank: ".concat(movie.getRank()));            
            System.out.println("Title: ".concat(movie.getTitle()));            
            System.out.println("Poster: ".concat(movie.getPosterURL()));            
            System.out.println("Rating: ".concat(movie.getRating()));         
            System.out.println("-----//-----");   
        }
    }

    private static String returnMoviesListJson() throws IOException, InterruptedException {
        var url = "https://api.mocki.io/v2/549a5d8b";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();        
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();
    }
}
 