package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RetrieveCoinsList {

    private final KeyApi API = new KeyApi();
    private final String addressURLToDownloadCoinsList = "https://api.coingecko.com/api/v3/coins/list";
    public final String filePathName = "coinListFile.txt";
    private final HttpClient client = HttpClient.newHttpClient();

    public void RetrieveCoinsListAndSaveItInAFile() {
        try {
            if(!dataIsAlreadyExistsInFile()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(addressURLToDownloadCoinsList))
                        .header("accept", "application/json")
                        .header("x-cg-pro-api-key", API.APIKEY)
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                saveResponseToFile(response.body());

            } else {
                System.out.println("Files already exist");
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveResponseToFile(String responseCoins) {
        try {
            Path filePath = Paths.get(filePathName);
            Files.writeString(filePath, responseCoins);
            System.out.println("File written to " + filePath.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Error saving the file.", e);
        }
    }

    public boolean dataIsAlreadyExistsInFile() throws IOException {
        Path filePath = Paths.get(filePathName);
        return Files.exists(filePath) && Files.size(filePath) > 0;
    }
}
