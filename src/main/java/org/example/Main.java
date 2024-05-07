package org.example;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        CoinGeckoAPIUsage coinGeckoAPIUsage = new CoinGeckoAPIUsage();
        coinGeckoAPIUsage.APIUsage();
        HttpResponse<String> response = coinGeckoAPIUsage.APIUsage();
        System.out.println(response.body());
    }
}