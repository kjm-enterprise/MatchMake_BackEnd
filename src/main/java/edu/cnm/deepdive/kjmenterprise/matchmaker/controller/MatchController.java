package edu.cnm.deepdive.kjmenterprise.matchmaker.controller;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.UserStorageRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class MatchController {
  @PostMapping("/match")
  public void createMatch(@Query("first_user") long firstUser, @Query("second_user") long secondUser) {
    // 1) Query UserStorageRepository to get users (from ids passed in)
    // 2) Set users as matches through the "matches" property in UserStorage class.
    // 3) Write to database.


  }
}
