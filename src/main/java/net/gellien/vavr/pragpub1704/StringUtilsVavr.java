package net.gellien.vavr.pragpub1704;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import java.io.File;

public class StringUtilsVavr {
  public static String combinePathWithBinVavr(java.util.List<String> paths){
    return Stream.ofAll(paths)
        .filter(path -> path.contains("/bin"))
        .map(path -> path.replaceAll("/bin", "/sbin"))
        .intersperse(java.io.File.pathSeparator)
        .reduce((p1, p2) -> p1.concat(p2));
  }

}
