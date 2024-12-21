package modulos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ObtenerMoneda {
    public Moneda getMoneda(String base, String objetivo) {
        double tasa;
        String apiKey = System.getenv("API_KEY_ConversorDeMonedas");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("API Key no encontrada.");
        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                + apiKey + "/latest/" + base);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Map<String, Object> apiResponse = gson.fromJson(response.body(), Map.class);

            if (!apiResponse.containsKey("base_code") || !apiResponse.containsKey("conversion_rates")) {
                throw new RuntimeException("Erorr en la respuesta de la API.");
            }

            String monedaBase = (String) apiResponse.get("base_code");
            Map<String, Double> tasas = (Map<String, Double>) apiResponse.get("conversion_rates");

            tasa = tasas.get(objetivo);

            Moneda moneda = new Moneda(base, objetivo, tasa);

            GeneradorArchivoJSON generador = new GeneradorArchivoJSON();
            generador.guardarJSON(moneda);

            return moneda;
        } catch (Exception e) {
            throw new RuntimeException("Error. No se encontró la moneda.");
        }
    }
}
