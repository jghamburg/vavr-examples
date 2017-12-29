package net.gellien.vavr.pragpub1702;

import lombok.Data;

@Data
public class Person {

  private final String name;
  private final int age;

  public Person(String theName, int theAge) {
    name = theName;
    age = theAge;
  }
}