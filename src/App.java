import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer conexão HTTP e buscar os filmes
        Scanner scan = new Scanner(System.in);
        System.out.println("Which one do you want ?");
        System.out.println("Most popular TVs(1) \n Top 250 movies(2)");
        int option = scan.nextInt();

        String url = "";

        
        if(option == 1){
            url = "https://imdb-api.com/en/API/MostPopularTVs/k_s0xlqz72";
        }else{
            url = "https://imdb-api.com/en/API/Top250Movies/k_s0xlqz72";
        }

        

        
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);
        
        //extrair só os dados
        var parser = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //exibir dados
        System.out.println("\u001b[31m ====================================================================================== ");
        for (Map<String,String> filme : listaDeFilmes) {

            System.out.println("\u001b[32m Title: " + filme.get("title")+ "\u001b[m");
            System.out.println("\u001b[1m Poster: "+ filme.get("image"));
            System.out.println("\u001b[31m \u001b[44m Classification: " + filme.get("imDbRating") + " \u001b[m ");
            System.out.println(" \u001b[31m ====================================================================================== ");
        }
    }
}



