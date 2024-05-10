package org.example;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        // --- ConnectWithAPICoinGecko ---
//        ConnectWithAPICoinGecko coinGeckoAPIUsage = new ConnectWithAPICoinGecko();
//        coinGeckoAPIUsage.CheckAPIServerStatus();
//        HttpResponse<String> response = coinGeckoAPIUsage.CheckAPIServerStatus();
//        System.out.println(response.body());

        // --- RetrieveCoinsList ---
        RetrieveCoinsList retrieveCoinsList  = new RetrieveCoinsList();
        retrieveCoinsList.RetrieveCoinsListAndSaveItInAFile();
//        HttpResponse<String> response = retrieveCoinsList.RetrieveCoinsListAndSaveItInAFile();



    }
}