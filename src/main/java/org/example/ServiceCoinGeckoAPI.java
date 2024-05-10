package org.example;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceCoinGeckoAPI {

    private final String filePathName = "coinListFile.txt";
    private final HttpClient client = HttpClient.newHttpClient();

    public void saveResponseToFile(String responseCoins) {
        try {
            Path filePath = Paths.get(filePathName);
            Files.writeString(filePath, responseCoins);
            System.out.println("File written to " + filePath.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Error saving the file.", e);
        }
    }
}
