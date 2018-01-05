package net.gellien.vavr.pragpub1703;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindPerson {

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

  public static void findFirstAdult(List<Person> people) {
    Person firstAdult = null;
    for (Person person : people) {
      if (person.getAge() > 17) {
        firstAdult = person;
        break;
      }
    }

    if (firstAdult != null) {

      log.info("The first adult in the list is "
          + firstAdult.getName());
    } else {
      log.info("No adults in the given list");
    }
  }

  public static void main(String[] args) {
    List<Person> people = createPeople();

    findFirstAdult(people);
    log.info("The functional style:");
    log.info(people.stream()
    .filter(person -> person.getAge() > 17)
    .findFirst()
    .map(person -> "The first adult in the list is "
    + person.getName())
    .orElse("No adult found in the list"));
  }
}