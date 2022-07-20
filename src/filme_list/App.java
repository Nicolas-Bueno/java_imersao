package filme_list;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        // Fazendo conexão HTTP e buscando os filmes
        Conection conec = new Conection();
        Scanner scan = new Scanner(System.in);
        String url = "";
        boolean flag = false;
        do {
            
            System.out.println("Which one do you want ?");
            System.out.println("Most popular TVs (1) \nTop 250 movies (2)");
            int option = scan.nextInt();

            switch (option) {
                case 1: {
                    url = "https://imdb-api.com/en/API/MostPopularTVs/k_s0xlqz72";
                    conec.setUrl(url);
                    flag = true;
                    break;
                }
                case 2: {
                    url = "https://imdb-api.com/en/API/Top250Movies/k_s0xlqz72";
                    conec.setUrl(url);
                    flag = true;
                    break;
                }
                default:
                    System.out.println("Try again!");
                    break;
            }
      } while (flag == false);  

        conec.setAddress(URI.create(url));
        conec.setClient(HttpClient.newHttpClient());
        conec.setRequest(HttpRequest.newBuilder(conec.getAddress()).GET().build());
        conec.setResponse(conec.getClient().send(conec.getRequest(), BodyHandlers.ofString()));
        conec.setBody(conec.getResponse().body());
        

        //extraindo os dados
        var parser = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parser.parse(conec.getBody());

        //exibindo dados
        System.out.println("\u001b[31m ====================================================================================== ");
        for (Map<String,String> filme : listaDeFilmes) {

            System.out.println("\u001b[32m Title: " + filme.get("title")+ "\u001b[m");
            //System.out.println("\u001b[1m Poster: "+ filme.get("image"));
            System.out.println("\u001b[31m \u001b[44m Classification: " + filme.get("imDbRating") + " \u001b[m ");
           System.out.println(" \u001b[31m ====================================================================================== ");
        }

        scan.close();
    }
}



