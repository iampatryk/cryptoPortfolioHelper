package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectWithAPICoinGecko {

    private final KeyApi API = new KeyApi();
//    private final RetrieveCoinsList serviceCoinGeckoAPI = new RetrieveCoinsList();
    private final String addressURLToConnectWithCoinGeckoApi = "https://api.coingecko.com/api/v3/ping?x_cg_demo_api_key=";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> CheckAPIServerStatus() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(addressURLToConnectWithCoinGeckoApi + API.APIKEY ))
                    .header("accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
