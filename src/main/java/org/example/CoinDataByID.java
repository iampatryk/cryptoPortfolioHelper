package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoinDataByID {

    private final KeyApi API = new KeyApi();
    private final String addressURLToGetCoinByID = "https://pro-api.coingecko.com/api/v3/coins/id";
    private final HttpClient client = HttpClient.newHttpClient();


    public HttpResponse<String> getCoinDataByID(String coinID) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(addressURLToGetCoinByID + "/" + coinID))
//                .uri(URI.create(addressURLToGetCoinByID))
                .GET()
                .header("accept", "application/json")
                .header("x-cg-pro-api-key", API.APIKEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                 return response;

        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
