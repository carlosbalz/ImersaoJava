import java.net.URL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpaceImage {
    @JsonProperty("date")
    private String date;

    @JsonProperty("explanation")
    private String explanation;

    @JsonProperty("hdurl")
    private URL hdurl;    

    @JsonProperty("media_type")
    private String media_type;

    @JsonProperty("service_version")
    private String service_version;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private URL ulr;

    public URL getHdurl() {
        return hdurl;
    }

    public String getTitle() {
        return title;
    }
}