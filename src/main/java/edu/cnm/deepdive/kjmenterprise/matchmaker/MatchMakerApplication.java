/**
 * @authors Kanyon Wyman, Michael Sanchez, James Mattos
 * @version 1.0
 */
package edu.cnm.deepdive.kjmenterprise.matchmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Launches the actual springboot server
 */

@SpringBootApplication
public class MatchMakerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MatchMakerApplication.class, args);
  }

}
