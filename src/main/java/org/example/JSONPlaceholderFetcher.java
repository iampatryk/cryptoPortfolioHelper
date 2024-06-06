package org.example;

import java.net.http.HttpResponse;

public class JSONPlaceholderFetcher {

    private CoinDataByID coinDataByID = new CoinDataByID();
    private CoinHistoricalDataByID coinHistoricalDataByID = new CoinHistoricalDataByID();

//    public JSONPlaceholderFetcher(CoinDataByID coinDataByID, CoinHistoricalDataByID coinHistoricalDataByID) {
//        this.coinDataByID = coinDataByID;
//        this.coinHistoricalDataByID = coinHistoricalDataByID;
//    }

    public Coin getCoinByIDJSON(String coinID) {
        HttpResponse<String> response = coinDataByID.getCoinDataByID(String.valueOf(coinID));
        System.out.println(response.body());
        if(response.statusCode() == 200) {
            return JSONMapper.convertToJSON(response.body());
        } else {
            throw new RuntimeException();
        }
    }

    public Coin getCoinHistoricalDataByIDJSON(String coinID) throws RuntimeException {
        HttpResponse<String> response = coinHistoricalDataByID.getCoinHistoricalDataByID(String.valueOf(coinID));
        System.out.println(response.body());
        if(response.statusCode() == 200) {
            return JSONMapper.convertToJSON(response.body());
        } else {
            throw new RuntimeException();
        }
    }
}
