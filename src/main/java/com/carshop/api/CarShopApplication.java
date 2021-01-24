package com.carshop.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Car shop application class.
 *
 * @author Shivaji Pote
 */
@SpringBootApplication
@Log4j2
public class CarShopApplication {

  /**
   * Main method which initializes the app.
   *
   * @param args
   */
  public static void main(final String[] args) {
    SpringApplication.run(CarShopApplication.class, args);
  }

}
