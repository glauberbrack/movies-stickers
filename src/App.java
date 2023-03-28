import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // HTTP requests
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI uri_address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var requestTopMovies = HttpRequest.newBuilder(uri_address).GET().build();
        HttpResponse<String> response = client.send(requestTopMovies, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // Parse json to get only Title, Poster and Classification
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);

        for (Map<String, String> movie: moviesList) {
            double averageRating = Double.parseDouble((movie.get("imDbRating")))/2;

            System.out.println("\u001b[1mTitle: \u001b[m" + movie.get("title"));
            System.out.println("\u001b[1mPoster: \u001b[m" +movie.get("image"));
            System.out.print("\u001b[1mRating: \u001b[m" +movie.get("imDbRating"));
            System.out.print(" ");
            for(int iterator = 1; iterator <= averageRating; iterator++ ) {
                System.out.print("⭐️");
            }
            System.out.print("\n");
            
        }
    }
}
