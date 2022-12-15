package conversor_divisas.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

/**
 *
 * @author Esau Montiel
 */
public class APIService {

    private final HttpClient client;
    private final String URL = "https://api.getgeoapi.com/v2/currency/";
    private final String key = "?api_key=529af84924f9d63f4f24efab16426365dde15234";
    
    public APIService() {
        this.client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .followRedirects(Redirect.NORMAL)
                .build();
    }
    
    public String getEquivalencias() {
        
        try {
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI (this.URL + "convert" + this.key))
                    .GET()
                    .build();
            
            return this.client.send(request, BodyHandlers.ofString()).body();
            
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            System.out.println("ex = " + ex.toString());
            return this.getEquivalencias();
        }
    }
   
}
