package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoinHistoricalDataByID {

    private final String addressURLToDownloadCoinsList = "https://api.coingecko.com/api/v3/coins/";
    private final KeyApi API = new KeyApi();
    private HttpClient client = HttpClient.newHttpClient();

//    public CoinHistoricalDataByID() {
//        this.client = client;
//    }

    public HttpResponse<String> getCoinHistoricalDataByID(String coinID, String date) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coingecko.com/api/v3/coins/" + coinID  + "/history?date=" + date))
                    .header("accept", "application/json")
                    .header("x-cg-demo-api-key", API.APIKEY)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
            return response;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
