package net.gellien.vavr.pragpub1701;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StockPricesParallelStream {

  public static String getPriceFor(String ticker) {
    return ticker + " : " + YahooFinance.getPrice(ticker);
  }

  public static void main(String[] args) {
    try {
      List<String> tickers =
          Arrays.asList("GOOG", "AMZN", "AAPL", "MSFT", "INTC", "ORCL");

      ExecutorService executorService =
          Executors.newFixedThreadPool(100);

      // Java 8 parallel streams
      tickers.parallelStream().map(StockPrices::getPriceFor)
          .forEachOrdered(log::info);

      executorService.shutdown();
      executorService.awaitTermination(100, TimeUnit.SECONDS);
    } catch (Exception ex) {
      log.info(ex.getMessage());
    }
  }
}

