import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception{
        // Fazer conexão HTTP e buscar os filmes
        String url = "https://imdb-api.com/en/API/Top250Movies/k_s0xlqz72";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        
        //extrair só os dados
        JsonParse parser = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
    
    }
}

