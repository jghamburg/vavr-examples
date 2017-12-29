package net.gellien.vavr.pragpub1701;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingThread {

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {


      public void run() {
        log.info("Hello from another thread");
      }
    });

    thread.start();
    log.info("Hello from main");
  }
}

