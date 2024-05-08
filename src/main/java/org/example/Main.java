package org.example;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        ConnectWithAPICoinGecko coinGeckoAPIUsage = new ConnectWithAPICoinGecko();
        coinGeckoAPIUsage.CheckAPIServerStatus();
        HttpResponse<String> response = coinGeckoAPIUsage.CheckAPIServerStatus();
        System.out.println(response.body());
    }
}