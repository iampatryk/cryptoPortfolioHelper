package org.example;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        // --- ConnectWithAPICoinGecko ---
//        ConnectWithAPICoinGecko coinGeckoAPIUsage = new ConnectWithAPICoinGecko();
//        coinGeckoAPIUsage.CheckAPIServerStatus();
//        HttpResponse<String> response = coinGeckoAPIUsage.CheckAPIServerStatus();
//        System.out.println(response.body());

        // --- RetrieveCoinsList ---
//        RetrieveCoinsList retrieveCoinsList  = new RetrieveCoinsList();
//        retrieveCoinsList.retrieveCoinsListAndSaveItInAFile();
//        HttpResponse<String> response = retrieveCoinsList.RetrieveCoinsListAndSaveItInAFile();

        // --- Getting coin by ID ---
//        CoinDataByID coinDataByID = new CoinDataByID();
//        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(coinDataByID);
//        System.out.println(jsonPlaceholderFetcher.getCoinByID("eggdog"));

        // --- Getting coin by ID form FILE ---
//        CoinDataByIDFromFile coinDataByIDFromFile = new CoinDataByIDFromFile();
//        coinDataByIDFromFile.getCoinByIDFromFile();

        // --- Getting historical data coin by ID ---
            CoinHistoricalDataByID coinHistoricalDataByID = new CoinHistoricalDataByID();
            JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher();
//            System.out.println(jsonPlaceholderFetcher.getCoinHistoricalDataByIDJSON("chuck-on-eth","02-02-2022"));
            HttpResponse<String> response = coinHistoricalDataByID.getCoinHistoricalDataByID("safeblast", "30-12-2023");
            System.out.println(response.body());
    }
}