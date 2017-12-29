package net.gellien.vavr.pragpub1701;

import java.util.*;
import java.util.concurrent.*;

public class StockPrices {

  public static String getPriceFor(String ticker) {
    return ticker + " : " + YahooFinance.getPrice(ticker);
  }

  public static void main(String[] args) {
    try {
      List<String> tickers =
          Arrays.asList("GOOG", "AMZN", "AAPL", "MSFT", "INTC", "ORCL");

      ExecutorService executorService =
          Executors.newFixedThreadPool(100);

      List<Future<String>> pricesFutures = new ArrayList<>();

      for (String ticker : tickers) {
        pricesFutures.add(executorService.submit(new Callable<String>() {
          public String call() {
            return getPriceFor(ticker);
          }
        }));
      }

      for (Future<String> priceFuture : pricesFutures) {
        System.out.println(priceFuture.get());
      }

      executorService.shutdown();
      executorService.awaitTermination(100, TimeUnit.SECONDS);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}

