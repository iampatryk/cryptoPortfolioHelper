package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CoinDataByIDFromFile {


    public void getCoinByIDFromFile() {

        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);

        try {
            String coinData = readFile("coinsListFile.txt");
            List<Coin> coins = mapper.readValue(coinData, new TypeReference<List<Coin>>(){});

            System.out.println("Entry coin name: ");
            String userInput = scanner.nextLine();

            Coin result = searchByName(userInput,coins);

            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("No entry found");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                fileContent.append(currentLine);
            }
        }
        return fileContent.toString();
    }

    private static Coin searchByName(String name, List<Coin> coins) {
        for (Coin coin : coins) {
            if (coin.getName().equals(name)) {
                return coin;
            }
        }
        return null;
    }
}
