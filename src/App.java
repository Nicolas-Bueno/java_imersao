import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // API nasa
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

        // minha API (linguagens mais utilizadas em 2022)
         String url = "http://localhost:8080/linguagens-mais-usadas-em-2022";

        //API imdb
        //String  url = "https://imdb-api.com/en/API/MostPopularTVs/k_s0xlqz72";

        // var extrator = new ExtratorConteudoNasa();
        var extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClientHttp();
        String json = http.buscaDados(url);

        // ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for(int i=0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}
