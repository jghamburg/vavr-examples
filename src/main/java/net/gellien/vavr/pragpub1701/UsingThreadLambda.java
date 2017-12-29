package net.gellien.vavr.pragpub1701;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingThreadLambda {

  public static void main(String[] args) {
    Thread thread = new Thread(() ->
        System.out.println("Hello from another thread"));
    thread.start();
    System.out.println("Hello from main");
  }
}

