package net.gellien.vavr.pragpub1701;

import io.vavr.collection.Stream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StockPricesVavrStream {

  public static String getPriceFor(String ticker) {
    return ticker + " : " + YahooFinance.getPrice(ticker);
  }

  public static void main(String[] args) {
    try {
      io.vavr.collection.List<String> tickers =
          io.vavr.collection.List.of("GOOG", "AMZN", "AAPL", "MSFT", "INTC", "ORCL");

      ExecutorService executorService =
          Executors.newFixedThreadPool(100);

      // Java 8 parallel streams
      Stream<String> tickerStream = tickers.toStream();
      tickerStream.map(StockPrices::getPriceFor).sorted().forEach(System.out::println);

      executorService.shutdown();
      executorService.awaitTermination(100, TimeUnit.SECONDS);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}

