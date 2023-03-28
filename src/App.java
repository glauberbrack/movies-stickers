import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI uri_address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var requestTopMovies = HttpRequest.newBuilder(uri_address).GET().build();
        HttpResponse<String> response = client.send(requestTopMovies, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        
    }
}
