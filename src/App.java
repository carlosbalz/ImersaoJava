import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {    
    public static void main(String[] args) throws Exception {        
        // create a http connection to the public api
        // convert the return json to a list of movies using DTOs
        // then print the extracted data
        // also will generate WhatsApp stickers from the movies posters links

        //https://api.mocki.io/v2/549a5d8b top 10 popular movies
        //https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope JamesWebb images

        var mapper = new ObjectMapper();
        var moviesJson = ApiRequester.getApiJsonReturn("https://api.mocki.io/v2/549a5d8b");        
        var content = mapper.readValue(moviesJson, Items.class);            
        var movies = content.getItems();        
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
}