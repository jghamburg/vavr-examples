package net.gellien.vavr.pragpub1705

import spock.lang.*

class SortPeopleVavrTest extends Specification {

  def "test create People"() {
    when:
    List<Person> result = SortPeopleVavr.createPeople()

    then:
    result.toString() == "[Sara 12, Jake 14, Nancy 21, Paul 32, Paula 20, Jack 32, Nick 16, Jill 15]"
  }

  def "test print Sorted By Age Using Sorted With Comparing"() {
    when:
    List<Person> result = SortPeopleVavr.printSortedByAgeUsingSortedWithComparing(SortPeople.createPeople())

    then:
    result.toString() == "[Sara 12, Jake 14, Jill 15, Nick 16, Paula 20, Nancy 21, Paul 32, Jack 32]"
  }

  def "test print Sorted By Age And Name Using Sorted With Comparing"() {
    when:
    List<Person> result = SortPeopleVavr.printSortedByAgeAndNameUsingSortedWithComparing(SortPeople.createPeople())

    then:
    result.toString() == "[Sara 12, Jake 14, Jill 15, Nick 16, Paula 20, Nancy 21, Jack 32, Paul 32]"
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme