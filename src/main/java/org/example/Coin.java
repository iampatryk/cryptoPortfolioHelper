package org.example;

import java.util.Objects;

public class Coin {

    public String id;
    public String symbol;
    public String name;
    public String date;

    public Coin(){}

    public Coin(String id, String symbol, String name, String date) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(id, coin.id) && Objects.equals(symbol, coin.symbol) && Objects.equals(name, coin.name) && Objects.equals(date, coin.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, name, date);
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id='" + id + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
