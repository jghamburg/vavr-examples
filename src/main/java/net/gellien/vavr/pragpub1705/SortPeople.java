package net.gellien.vavr.pragpub1705;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortPeople {

  private SortPeople() {
  }

  public static List<Person> createPeople() {
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

  public static List<Person> printSortedByNameTraditional(List<Person> people) {
    Collections.sort(people, new Comparator<Person>() {
      public int compare(Person first, Person second) {
        return first.getName().compareTo(second.getName());
      }
    });

    return people;
  }

  public static List<Person> printSortedByNameWitgLambda(List<Person> people) {
    Collections.sort(people, (first, second) ->
        first.getName().compareTo(second.getName()));
    return people;
  }

  public static List<Person> printSortedByNameUsingSorted(List<Person> people) {
    return people.stream()
        .sorted((first, second) ->
            first.getName().compareTo(second.getName()))
        .collect(Collectors.toList());
  }

  public static List<Person> printSortedByNameUsingSortedWithComparing(List<Person> people) {
    return people.stream()
        .sorted(comparing(Person::getName))
        .collect(Collectors.toList());
  }

  public static List<Person> printSortedByAgeUsingSortedWithComparing(List<Person> people) {
    return people.stream()
        .sorted(comparing(Person::getAge))
        .collect(Collectors.toList());
  }

  public static List<Person> printSortedByAgeAndNameUsingSortedWithComparing(List<Person> people) {
    return people.stream()
        .sorted(comparing(Person::getAge).thenComparing(Person::getName))
        .collect(Collectors.toList());
  }


}