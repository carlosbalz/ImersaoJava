import java.net.URL;

public class App {    
    public static void main(String[] args) throws Exception {        
        //https://api.mocki.io/v2/549a5d8b top 10 popular movies
        //https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope JamesWebb images
        //http://localhost:8080/favorite-languages api local

        var stickerGenerator = new StickerGenerator();

        // var moviesJson = new ApiRequester().getApiJsonReturn("https://api.mocki.io/v2/549a5d8b");
        // var movieList = new ImdbDataExtractor().getData(moviesJson);

        // for (Movie movie : movieList) {
        //     var fileURL = new URL(movie.getPosterURL()).openStream();
        //     stickerGenerator.create(fileURL, movie.getTitle() + ".png");
        // } 

        // var spaceImagesJson = new ApiRequester().getApiJsonReturn("https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope");        
        // var imageList = new NasaDataExtractor().getData(spaceImagesJson);   
        
        // for (SpaceImage image : imageList) {
        //     var fileURL = image.getHdurl().openStream();
        //     stickerGenerator.create(fileURL, image.getTitle() + ".png");
        // } 

        var languagesJson = new ApiRequester().getApiJsonReturn("http://localhost:8080/favorite-languages");
        var languageList = new LanguagesDataExtractor().getData(languagesJson);

        for (Language language : languageList) {
            var fileURL = new URL(language.getIcon()).openStream();
            stickerGenerator.create(fileURL, language.getTitle() + ".png");
        }
    }       
} 