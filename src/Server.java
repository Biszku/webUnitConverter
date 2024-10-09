import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

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

class lengthConversionHandler extends LengthConHan implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        handleAbstraction(exchange);
    }
}

class weightConversionHandler extends WeightConHan implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        handleAbstraction(exchange);
    }
}

class temperatureConversionHandler extends TemperatureConHan implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        handleAbstraction(exchange);
    }
}