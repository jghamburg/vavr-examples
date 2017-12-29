package net.gellien.vavr.pragpub1702;

import java.util.Arrays;
import java.util.List;

public class PrintNamesOfAdultsVavr {


  public static List<Person> createPeople() {
    return Arrays.asList(
        new Person("Sara", 12),
        new Person("Jake", 14),
        new Person("Nancy", 21),
        new Person("Paul", 20),
        new Person("Paula", 32),
        new Person("Jack", 32),
        new Person("Nick", 16),
        new Person("Jill", 15)
    );
  }

  public static void main(String[] args) {
    List<Person> people = createPeople();
    io.vavr.collection.List<String> basePeople = io.vavr.collection.List.ofAll(people)
        .filter(person -> person.getAge() > 17)
        .map(Person::getName);

    basePeople.map(String::toUpperCase)
        .forEach(System.out::println);

    basePeople.map(String::toLowerCase)
        .forEach(System.out::println);
  }
}