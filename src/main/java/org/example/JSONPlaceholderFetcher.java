package org.example;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSONPlaceholderFetcher {

    private CoinDataByID coinDataByID = new CoinDataByID();

    public JSONPlaceholderFetcher(CoinDataByID coinDataByID) {
        this.coinDataByID = coinDataByID;
    }

    public Coin getCoinByID(String coinID) {
        HttpResponse<String> response = coinDataByID.getCoinDataByID(String.valueOf(coinID));
        System.out.println(response.body());
        if(response.statusCode() == 200) {
            return JSONMapper.convertToJSON(response.body());
        } else {
            throw new RuntimeException();
        }
    }
}
