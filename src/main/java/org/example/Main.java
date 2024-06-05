package org.example;

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
        CoinDataByIDFromFile coinDataByIDFromFile = new CoinDataByIDFromFile();
        coinDataByIDFromFile.getCoinByIDFromFile();

    }
}