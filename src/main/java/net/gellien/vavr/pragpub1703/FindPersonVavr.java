package net.gellien.vavr.pragpub1703;

import io.vavr.collection.Stream;
import java.util.Arrays;
import java.util.List;

public class FindPersonVavr {

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

    System.out.println(Stream.ofAll(people)
        .filter(person -> person.getAge() > 22).headOption()
        .map(person -> "The first adult in the list is "
            + person.getName())
        .getOrElse("No person found!")
    );
    System.out.println("The End");
  }
}