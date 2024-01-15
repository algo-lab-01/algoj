package com.lab01.misc;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *

 You work in an electronic exchange. Throughout the day, you receive ticks (trading data) which
 consists of product name and its traded volume of stocks. Eg: {name: vodafone, volume: 20}

 What data structure will you maintain if:

     You have to tell top k products traded by volume at end of day.
     You have to tell top k products traded by volume throughout the day.
 */
public class StockExchangeMain {
    public static void main(String[] args) {
        int testSize = 1000000;
        System.out.println("TEst size - "+testSize);
        long startTime = System.currentTimeMillis();
        StockExchange stockExchange = new StockExchange();
        addRandomData(stockExchange, testSize);
        System.out.println("Top 3 stock");
        stockExchange.getTopK(3);
        stockExchange.getTopK(20);
        System.out.println("Time took in ms- "+(System.currentTimeMillis() - startTime));
    }

    private static void addRandomData(StockExchange stockExchange, int testSize) {
        String[] companies = {"a", "b", "c", "d", "e", "f", "g", "h", "i","j","k", "l","m","n","o","p"};
        long[] volumes = {100, 200, 300, 400, 500, 600};
        int i = 0;
        for(; i< testSize; i++){
            int cindex = ThreadLocalRandom.current().nextInt(0, companies.length);
            int vindex = ThreadLocalRandom.current().nextInt(0, volumes.length);
            stockExchange.addStock(new Stock(companies[cindex],volumes[vindex]));
        }
        System.out.println("value of i"+i);
    }
}

class StockExchange{
    // Stock Map with company name as Key and Volume of stock as Value
    Map<String, Stock> stockMap = new HashMap<>();

    List<Stock> stockSorted = new ArrayList<>();

    void addStock(Stock stock){
        String key = stock.getCompany();
        Long volume = stock.getVolume();


        Stock existing = stockMap.getOrDefault(key, null);
        if(null != existing)
            volume += existing.getVolume();
        stock.setVolume(volume);
        stockMap.put(key, stock);

        stockSorted.clear();
        stockSorted.addAll(stockMap.values());
        stockSorted.sort((Comparator.comparing(Stock::getVolume).reversed()));

    }

    void getTopK(int k){
         k = Math.min(k, stockSorted.size());
        for(int i=0 ; i < k; i++){
            System.out.println(stockSorted.get(i));
        }
    }
}

class Stock{
    private Long volume;
    private String company;

    public Stock(String company, Long volume){
        this.company = company;
        this.volume = volume;
    }
    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "volume=" + volume +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Stock stock = (Stock) object;
        return Objects.equals(company, stock.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company);
    }
}
