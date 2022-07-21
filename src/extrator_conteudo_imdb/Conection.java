package extrator_conteudo_imdb;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conection {
    private String url;
    private URI address;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String body;

    public URI getAddress() {
        return address;
    }


    public void setAddress(URI address) {
        this.address = address;
    }


    public HttpClient getClient() {
        return client;
    }


    public void setClient(HttpClient client) {
        this.client = client;
    }


    public HttpRequest getRequest() {
        return request;
    }


    public void setRequest(HttpRequest request) {
        this.request = request;
    }


    public HttpResponse<String> getResponse() {
        return response;
    }

    
    public void setResponse(HttpResponse<String> response) {
        this.response = response;
    }


    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }
    
}
