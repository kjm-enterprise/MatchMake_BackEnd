package edu.cnm.deepdive.kjmenterprise.matchmaker.controller;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.MatchRepository;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.UserStorageRepository;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Match;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.UserStorage;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.PropertyMapper.Source;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Match.class)
@RequestMapping("/matches")
public class MatchController {

  private MatchRepository matchRepository;
  private UserStorageRepository userStorageRepositor;

  @Autowired
  public MatchController(MatchRepository matchRepository, UserStorageRepository userStorageRepository) {
    this.matchRepository = matchRepository;
    this.userStorageRepositor = userStorageRepository;
  }

  @GetMapping(value = "random", produces = MediaType.APPLICATION_JSON_VALUE)
  public Match getRandom() {
    return matchRepository.findRandom().get();
  }

  @PostMapping(value = "/match",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Match createMatch(@PathVariable("userId") long firstUser, @PathVariable("userId") long secondUser) {
    UserStorage user = userStorageRepositor.findById(UUID.randomUUID()).get();

    // 1) Query UserStorageRepository to get users (from ids passed in)
    // 2) Set users as matches through the "matches" property in UserStorage class.
    // 3) Write to database.

  return null;
  }

}
