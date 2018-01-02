package net.gellien.vavr.pragpub1704

import spock.lang.*

class StringUtilsTest extends Specification {

  def "test combine Paths Imperative"() {
    when:
    String result = StringUtils.combinePathsImperative("path1", "path2", "path3")

    then:
    result == "path1:path2:path3"
  }

  def "test combine Paths Using Join"() {
    when:
    String result = StringUtils.combinePathsUsingJoin("path1", "path2", "path3")

    then:
    result == "path1:path2:path3"
  }

  def "test combine Path List Imperative"() {
    when:
    String result = StringUtils.combinePathListImperative(["/base/11/bin", "/base/12/name", "/base/13/bin"])

    then:
    result == "/base/11/bin:/base/12/name:/base/13/bin"
  }

  def "test combine Path List Using Join"() {
    when:
    String result = StringUtils.combinePathListUsingJoin(["/base/11/bin", "/base/12/name", "/base/13/bin"])

    then:
    result == "/base/11/bin:/base/12/name:/base/13/bin"
  }

  def "test combine Path With Bin"() {
    when:
    String result = StringUtils.combinePathWithBin(["/base/11/bin", "/base/12/name", "/base/13/bin"])

    then:
    result == "/base/11/sbin:/base/13/sbin"
  }

  def "test combine Path With Bin Java8"() {
    when:
    String result = StringUtils.combinePathWithBinJava8(["/base/11/bin", "/base/12/name", "/base/13/bin"])

    then:
    result == "/base/11/sbin:/base/13/sbin"
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme