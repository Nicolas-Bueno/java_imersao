package stikers;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppSticker {
    public static void main(String[] args) throws Exception {

        // Fazendo conexão HTTP e buscando os filmes
        var conec = new Conection2();
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
        var parser = new JsonParse2();
        List<Map<String, String>> listaDeFilmes = parser.parse(conec.getBody());

        var generator = new Generator();

        for (Map<String,String> filme : listaDeFilmes) {

            String urlImg = filme.get("image");
            String title = filme.get("title");

            InputStream inputStream = new URL(urlImg).openStream();
            String nameFile = title + ".png";

            generator.create(inputStream, nameFile);
            System.out.println(title);

        }
        scan.close();
    }
}
