package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {
    private final String apiBaseUrl;
    private final String apiKey;

    public ExchangeRateApi() {
        this.apiBaseUrl = "https://v6.exchangerate-api.com/v6";
        this.apiKey = System.getenv("EXCHANGE_RATE_API_KEY");
    }

    public String getExchangeRate(String baseCurrency, String targetCurrency, float amount) {
        String url = String.format("%s/%s/pair/%s/%s/%s", apiBaseUrl, apiKey, baseCurrency, targetCurrency, amount);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            return "Something went wrong: " + e;
        }
    }

    ;


}
