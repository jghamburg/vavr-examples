package net.gellien.vavr.pragpub1702;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintNamesOfAdults {


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

    for (int i = 0; i < people.size(); i++) {
      Person person = people.get(i);
      if (person.getAge() > 17) {
        log.info(person.getName().toUpperCase());
      }
    }
    log.info("_______________________");
    for(Person person : people){
      if (person.getAge() > 17){
        log.info(person.getName().toUpperCase());
      }
    }
  }
}