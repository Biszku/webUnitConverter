import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

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

class lengthConversionHandler extends conversionHandler implements HttpHandler {
    private String response = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {

            String formData = new String(exchange.getRequestBody().readAllBytes());
            Map<String, String> params = getValuesFromForm(formData);

            if(params == null) {
                response = new lengthPage().createPage();
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            double value = Double.parseDouble(params.get("value"));
            String from = params.get("from");
            String to = params.get("to");

            double convertedValue = Length.convertUnit(from, to);
            double result = value * convertedValue;

            response = new lengthPage().createResultPage("%.2f %s".formatted(value, from),
                    "%.2f %s".formatted(result,to));
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = new lengthPage().createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }

}

class weightConversionHandler extends conversionHandler implements HttpHandler {

    private String response = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {

            String formData = new String(exchange.getRequestBody().readAllBytes());
            Map<String, String> params = getValuesFromForm(formData);

            if(params == null) {
                response = new weightPage().createPage();
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            double value = Double.parseDouble(params.get("value"));
            String from = params.get("from");
            String to = params.get("to");

            double convertedValue = Weight.convertUnit(from, to);
            double result = value * convertedValue;

            response = new weightPage().createResultPage("%.2f %s".formatted(value, from),
                    "%.2f %s".formatted(result,to));
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = new weightPage().createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }
}

class temperatureConversionHandler extends conversionHandler implements HttpHandler {
    private String response = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {

            String formData = new String(exchange.getRequestBody().readAllBytes());
            Map<String, String> params = getValuesFromForm(formData);


            if(params == null) {
                response = new temperaturePage().createPage();
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            double value = Double.parseDouble(params.get("value"));

            String from = params.get("from");
            String to = params.get("to");

            String fromPrefix = !from.equals("K") ? "&#176" : "";
            String toPrefix = !to.equals("K") ? "&#176" : "";

            double result = Temperature.convert(value, from, to);

            response = new temperaturePage().createResultPage("%.2f %s".formatted(value, fromPrefix+from),
                    "%.2f %s".formatted(result, toPrefix+to));
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = new temperaturePage().createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }
}


