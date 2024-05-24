package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RetrieveCoinsList {

    private final KeyApi API = new KeyApi();
    private final Coin coinMapper = new Coin();
    private final String addressURLToDownloadCoinsList = "https://api.coingecko.com/api/v3/coins/list";
    private final String filePathName = "coinsListFile.txt";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void retrieveCoinsListAndSaveItInAFile() {
        try {
            if(!dataAlreadyExistsinFile()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(addressURLToDownloadCoinsList))
                        .header("accept", "application/json")
                        .header("x-cg-pro-api-key", API.APIKEY)
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                saveResponseToFile(response.body());

            } else {
                System.out.println("Coins list is already downloaded");
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveResponseToFile(String responseCoins) {
        try {
            Path filePath = Paths.get(filePathName);
            Set<Coin> existingCoins = new HashSet<>();

            if (Files.exists(filePath)) {
                List<String> existingContent = Files.readAllLines(filePath);
                if (!existingContent.isEmpty()) {
                    String existingJson = String.join("", existingContent);
                    List<Coin> existingCoinsList = objectMapper.readValue(existingJson, TypeFactory.defaultInstance().constructCollectionType(List.class, Coin.class));
                    existingCoins.addAll(existingCoinsList);
                }
            }

            List<Coin> newCoinsList = objectMapper.readValue(responseCoins, TypeFactory.defaultInstance().constructCollectionType(List.class, Coin.class));
            Set<Coin> newCoins = new HashSet<>(newCoinsList);

            newCoins.removeAll(existingCoins);
            existingCoins.addAll(newCoins);

            String updatedJson = objectMapper.writeValueAsString(existingCoins);
            Files.writeString(filePath, updatedJson);
            System.out.println("File updated at " + filePath.toAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException("Error updating the file.", e);
        }
    }

    private boolean dataAlreadyExistsinFile() throws IOException {
        Path filePath = Paths.get(filePathName);
        return Files.exists(filePath) && Files.size(filePath) > 0;
    }
}
