/**
 * @authors Kanyon Wyman, Michael Sanchez, James Mattos
 * @version 1.0
 */

package edu.cnm.deepdive.kjmenterprise.matchmaker.controller;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.MatchRepository;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Match;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.UserStorage;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Match.class)
@RequestMapping("/matches")
public class MatchController {

  private MatchRepository matchRepository;

  /**
   * auto wires the bean on the setter method
   * @param
   * @return
   */

  @Autowired
  public MatchController(MatchRepository matchRepository) {
    this.matchRepository = matchRepository;
  }

  /**
   * Creates a search value for the Match class in the table
   * @return
   */

  @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Match> search(@RequestParam("q") String fragment) {
    return matchRepository.findAllByTextContainingOrderByTextAsc(fragment);
  }

  /**
   * Gets the Match info
   * @return
   */

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Match> get() {
    return matchRepository.findAllByOrderByTextAsc();
  }

  /**
   * Gets a value for the matchId created in the MatchRepository interface
   * @param matchId
   * @return
   */

  @GetMapping(value = "{matchId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Match get(@PathVariable("matchId") UUID matchId) {
    return matchRepository.findById(matchId).get();
  }

  /**
   * Pairs matched users in the table with data take from the UserStorage entity
   * @param matchId
   * @param userStorage
   * @return
   */

  @PostMapping(value = "{matchId}/users", produces = MediaType.APPLICATION_JSON_VALUE)
  public Match attach(@PathVariable("matchId") UUID matchId, @RequestBody UserStorage userStorage) {
    Match match = get(matchId);
    match.getMatches().add(userStorage.getId());
    matchRepository.save(match);
    return match;
  }

  /**
   * Throws an exception if the requested resource is not in the table or does not exist
   */

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {}

}
