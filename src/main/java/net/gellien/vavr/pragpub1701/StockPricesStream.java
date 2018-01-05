package net.gellien.vavr.pragpub1701;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StockPricesStream {

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
      // lambda
      for (String ticker : tickers) {
        pricesFutures.add(executorService.submit(() -> getPriceFor(ticker)));
      }
      // Java 8 streams
      for (Future<String> priceFuture : pricesFutures) {
        log.info(priceFuture.get());
      }

      executorService.shutdown();
      executorService.awaitTermination(100, TimeUnit.SECONDS);
    } catch (Exception ex) {
      log.info(ex.getMessage());
    }
  }
}

