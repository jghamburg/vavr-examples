package net.gellien.vavr.pragpub1705

import spock.lang.*

class SortPeopleTest extends Specification {

  def "test create People"() {
    when:
    List<Person> result = SortPeople.createPeople()

    then:
    result.toString() == "[Sara 12, Jake 14, Nancy 21, Paul 32, Paula 20, Jack 32, Nick 16, Jill 15]"
  }

  def "test print Sorted By Name Traditional"() {
    when:
    def result = SortPeople.printSortedByNameTraditional(SortPeople.createPeople())

    then:
    result.toString() == "[Jack 32, Jake 14, Jill 15, Nancy 21, Nick 16, Paul 32, Paula 20, Sara 12]"
  }

  def "test print Sorted By Name Witg Lambda"() {
    when:
    def result = SortPeople.printSortedByNameWitgLambda(SortPeople.createPeople())

    then:
    result.toString() == "[Jack 32, Jake 14, Jill 15, Nancy 21, Nick 16, Paul 32, Paula 20, Sara 12]"
  }

  def "test print Sorted By Name Using Sorted"() {
    when:
    def result = SortPeople.printSortedByNameUsingSorted(SortPeople.createPeople())

    then:
    result.toString() == "[Jack 32, Jake 14, Jill 15, Nancy 21, Nick 16, Paul 32, Paula 20, Sara 12]"
  }

  def "test print Sorted By Name Using Sorted With Comparing"() {
    when:
    def result = SortPeople.printSortedByNameUsingSortedWithComparing(SortPeople.createPeople())

    then:
    result.toString() == "[Jack 32, Jake 14, Jill 15, Nancy 21, Nick 16, Paul 32, Paula 20, Sara 12]"
  }

  def "test print Sorted By Age Using Sorted With Comparing"() {
    when:
    def result = SortPeople.printSortedByAgeUsingSortedWithComparing(SortPeople.createPeople())

    then:
    result.toString() == "[Sara 12, Jake 14, Jill 15, Nick 16, Paula 20, Nancy 21, Paul 32, Jack 32]"

  }

  def "test print Sorted By Age And Name Using Sorted With Comparing"() {
    when:
    def result = SortPeople.printSortedByAgeAndNameUsingSortedWithComparing(SortPeople.createPeople())

    then:
    result.toString() == "[Sara 12, Jake 14, Jill 15, Nick 16, Paula 20, Nancy 21, Jack 32, Paul 32]"
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme