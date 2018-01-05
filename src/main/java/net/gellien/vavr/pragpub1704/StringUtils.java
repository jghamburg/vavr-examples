package net.gellien.vavr.pragpub1704;

public class StringUtils {

  public static final String BIN = "/bin";
  public static final String SBIN = "/sbin";

  public static String combinePathsImperative(String path1,
      String path2, String path3) {
    final String separator = java.io.File.pathSeparator;

    return path1 + separator + path2 + separator + path3;
  }

  public static String combinePathsUsingJoin(String path1,
      String path2, String path3) {
    return String.join(java.io.File.pathSeparator, path1, path2, path3);
  }

  public static String
  combinePathListImperative(java.util.List<String>
      paths) {
    final String separator = java.io.File.pathSeparator;

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < paths.size() - 1; i++) {
      result.append(paths.get(i) + separator);
    }

    if (paths.isEmpty()) {
      result.append(paths.get(paths.size() - 1));
    }

    return result.toString();
  }

  public static String combinePathListUsingJoin(java.util.List<String> paths) {
    return String.join(java.io.File.pathSeparator, paths);
  }

  public static String
  combinePathWithBin(java.util.List<String> paths) {
    final String separator = java.io.File.pathSeparator;

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < paths.size() - 1; i++) {
      String path = paths.get(i);

      if (path.contains(BIN)) {
        result.append(path.replaceAll(BIN, SBIN) + separator);
      }
    }

    if (paths.isEmpty()) {
      String path = paths.get(paths.size() - 1);
      if (path.contains(BIN)) {
        result.append(path.replaceAll(BIN, SBIN));
      }
    }
    return result.toString();
  }

  public static String combinePathWithBinJava8(java.util.List<String> paths) {
    return paths.stream()
        .filter(path -> path.contains(BIN))
        .map(path -> path.replaceAll(BIN, SBIN))
        .collect(java.util.stream.Collectors.joining
            (java.io.File.pathSeparator));
  }

}