package org.example;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RetrieveCoinsList {

    private CoinsAPIHandler coinsAPIHandler;

    private final KeyApi API = new KeyApi();
    private final String addressURLToDownloadCoinsList = "https://api.coingecko.com/api/v3/coins/list";
    private HttpClient client;

    public RetrieveCoinsList(HttpClient client, CoinsAPIHandler coinsAPIHandler) {
        this.coinsAPIHandler = coinsAPIHandler;
        this.client = client;
    }

    public void retrieveCoinsListAndSaveItInAFile() {
        try {
            if(!coinsAPIHandler.dataAlreadyExistsinFile()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(addressURLToDownloadCoinsList))
                        .header("accept", "application/json")
                        .header("x-cg-pro-api-key", API.APIKEY)
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                coinsAPIHandler.saveResponseToFile(response.body());

            } else {
                System.out.println("Coins list is already downloaded");
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
