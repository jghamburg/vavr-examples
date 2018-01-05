package net.gellien.vavr.pragpub1704;

import io.vavr.collection.Stream;

public class StringUtilsVavr {

  public static final String BIN = "/bin";
  public static final String SBIN = "/sbin";

  private StringUtilsVavr() {
  }

  public static String combinePathWithBinVavr(java.util.List<String> paths){
    return Stream.ofAll(paths)
        .filter(path -> path.contains(BIN))
        .map(path -> path.replaceAll(BIN, SBIN))
        .intersperse(java.io.File.pathSeparator)
        .reduce((p1, p2) -> p1.concat(p2));
  }

}
