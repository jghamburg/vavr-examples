package net.gellien.vavr.pragpub1704

import spock.lang.*

class StringUtilsVavrTest extends Specification {

  def "test combine Path With Bin Vavr"() {
    when:
    String result = StringUtilsVavr.combinePathWithBinVavr(["/base/11/bin", "/base/12/name", "/base/13/bin"])

    then:
    result == "/base/11/sbin:/base/13/sbin"
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme