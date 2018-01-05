package net.gellien.vavr.pragpub1701;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YahooFinance {

  private YahooFinance() {
  }

  public static double getPrice(final String ticker) {
    try {
      final URL url =
          new URL("https://www.quandl.com/api/v1/datasets/WIKI/" + ticker
              + ".csv?column=4&sort_order=asc&collapse=quarterly&trim_start=2012-01-01&trim_end=2012-02-28");
      String[] dataItems;
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
        dataItems = reader.lines().collect(toList()).get(1).split(",");
      }

      return Double.parseDouble(dataItems[dataItems.length - 1]);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
}