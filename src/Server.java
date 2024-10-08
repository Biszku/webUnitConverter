import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private static final int PORT = 8080;


    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(Server.PORT), 0);
            server.createContext("/length", new lengthConversionHandler());
            server.createContext("/weight",  new weightConversionHandler());
            server.createContext("/temperature", new temperatureConversionHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Server listening on port 8080");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class lengthConversionHandler  implements HttpHandler {

    private String response = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            String formData = new String(exchange.getRequestBody().readAllBytes());
            List<String> params = getValuesFromForm(formData);

            response = new lengthPage().createResultPage("mm", "mm");
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = new lengthPage().createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }
    private List<String> getValuesFromForm(String formData) {
        String regex = "value=([^&]*)&from=([^&]*)&to=([^&]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formData);

        if (matcher.find()) {
            List<String> params = new ArrayList<>();

            params.add(matcher.group(1));
            params.add(matcher.group(2));
            params.add(matcher.group(3));

            return params;
        }
        return null;
    }
}

class weightConversionHandler implements HttpHandler {

    private String response = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            String formData = new String(exchange.getRequestBody().readAllBytes());
            List<String> params = getValuesFromForm(formData);
            response = new weightPage().createResultPage("mm", "mm");
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = new weightPage().createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }

    private List<String> getValuesFromForm(String formData) {
        String regex = "value=([^&]*)&from=([^&]*)&to=([^&]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formData);

        if (matcher.find()) {
            List<String> params = new ArrayList<>();

            params.add(matcher.group(1));
            params.add(matcher.group(2));
            params.add(matcher.group(3));

            return params;
        }
        return null;
    }
}

class temperatureConversionHandler implements HttpHandler {

    private String response = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            String formData = new String(exchange.getRequestBody().readAllBytes());
            List<String> params = getValuesFromForm(formData);
            response = new temperaturePage().createResultPage("C", "F");
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = new temperaturePage().createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }

    private List<String> getValuesFromForm(String formData) {
        String regex = "value=([^&]*)&from=([^&]*)&to=([^&]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formData);

        if (matcher.find()) {
            List<String> params = new ArrayList<>();

            params.add(matcher.group(1));
            params.add(matcher.group(2));
            params.add(matcher.group(3));

            return params;
        }
        return null;
    }
}


