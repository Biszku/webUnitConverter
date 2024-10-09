import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ConversionHandler {

    public void handle(HttpExchange exchange) throws IOException {
        String response = "";
        PageCreator page = getPage();
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {

            String formData = new String(exchange.getRequestBody().readAllBytes());
            Map<String, String> params = getValuesFromForm(formData);

            if(params == null) {
                response = page.createPage();
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            double value = Double.parseDouble(params.get("value"));
            String from = params.get("from");
            String to = params.get("to");

            double result = convertUnit(value, from, to);

            response = page.createResultPage("%.2f %s".formatted(value, from),
                    "%.2f %s".formatted(result,to));
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            response = page.createPage();
        }

        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.close();
    }

    public Map<String, String> getValuesFromForm(String formData) {

        String regex = "value=(\\d+)&from=(\\w+)&to=(\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formData);

        if (matcher.find()) {
            Map<String, String> params = new HashMap<>();

            params.put("value", matcher.group(1));
            params.put("from", matcher.group(2));
            params.put("to", matcher.group(3));

            return params;
        }
        return null;
    }

    abstract PageCreator getPage();
    abstract double convertUnit(double value, String from, String to);
}
