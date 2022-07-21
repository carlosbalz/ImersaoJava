import java.io.IOException;
import java.net.URI;
import java.net.URL;
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
        // also will generate WhatsApp stickers from the movies posters links

        var json = returnMoviesListJson();
        var mapper = new ObjectMapper();
        var items = mapper.readValue(json, Items.class);    
        var movies = items.getItems();
        var stickerGenerator = new StickerGenerator();
            
        for (MoviesDTO movie : movies) {
            System.out.println("Rank: ".concat(movie.getRank()));            
            System.out.println("Title: ".concat(movie.getTitle()));            
            System.out.println("Poster: ".concat(movie.getPosterURL()));            
            System.out.println("Rating: ".concat(movie.getRating()));         
            System.out.println("-----//-----");   

            var fileURL = new URL(movie.getPosterURL()).openStream();
            stickerGenerator.create(fileURL, movie.getTitle() + ".png");
        }
    }

    private static String returnMoviesListJson() throws IOException, InterruptedException {
        var url = "https://api.mocki.io/v2/549a5d8b";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();        
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();
    }
}