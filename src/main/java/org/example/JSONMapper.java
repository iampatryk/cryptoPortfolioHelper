package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Coin convertToJSON(String coinJSON ) {
        Coin coin = new Coin();

        try {
            JsonNode node = mapper.readTree(coinJSON);
            coin.setId(node.get("id").textValue());
            coin.setName(node.get("name").textValue());
            coin.setSymbol(node.get("symbol").textValue());
            coin.setDate(node.get("date").textValue());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return coin;
    }

    public static String mapToJSON(Coin coin) {
        try {
            return mapper.writeValueAsString(coin);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
