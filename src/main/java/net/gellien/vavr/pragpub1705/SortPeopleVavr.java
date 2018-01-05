package net.gellien.vavr.pragpub1705;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;


public class SortPeopleVavr {

  private SortPeopleVavr() {
  }

  public static java.util.List<Person> createPeople() {
    return Arrays.asList(
        new Person("Sara", 12),
        new Person("Jake", 14),
        new Person("Nancy", 21),
        new Person("Paul", 32),
        new Person("Paula", 20),
        new Person("Jack", 32),
        new Person("Nick", 16),
        new Person("Jill", 15));
  }

  public static List<Person> printSortedByAgeUsingSortedWithComparing(List<Person> people) {
    return io.vavr.collection.List.ofAll(people)
        .sorted(comparing(Person::getAge)).toJavaList();
  }

  public static List<Person> printSortedByAgeAndNameUsingSortedWithComparing(List<Person> people) {
    return io.vavr.collection.List.ofAll(people)
        .sorted(comparing(Person::getAge).thenComparing(Person::getName))
        .toJavaList();
  }


}