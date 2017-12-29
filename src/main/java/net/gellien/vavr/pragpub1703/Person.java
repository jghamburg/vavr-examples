package net.gellien.vavr.pragpub1703;

import lombok.Data;

@Data
public class Person {

  private final String name;
  private final int age;

  public Person(String theName, int theAge) {
    name = theName;
    age = theAge;
  }
  public static final Person NO_PERSON = new Person("Nobody", 0);
}