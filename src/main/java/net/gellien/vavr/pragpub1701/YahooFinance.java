package net.gellien.vavr.pragpub1701;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.toList;


public class YahooFinance {

  public static double getPrice(final String ticker) {
    try {
      final URL url =
          new URL("https://www.quandl.com/api/v1/datasets/WIKI/AAPL"
              + ".csv?column=4&sort_order=asc&collapse=quarterly&trim_start=2012-01-01&trim_end=2012-02-28");
      final BufferedReader reader =
          new BufferedReader(new InputStreamReader(url.openStream()));

      final String[] dataItems =
          reader.lines().collect(toList()).get(1).split(",");
      double price =
          Double.parseDouble(dataItems[dataItems.length - 1]);
      return price;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}