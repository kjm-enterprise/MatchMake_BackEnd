package edu.cnm.deepdive.kjmenterprise.matchmaker.controller;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.LocationDao;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.MatchDao;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.UserStorageDao;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Location;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Match;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@ExposesResourceFor(Location.class)
@RequestMapping("/locations")
public class LocationController {

  private LocationDao locationDao;
  private MatchDao matchDao;
  private UserStorageDao userStorageDao;

  @Autowired
  public LocationController(LocationDao locationDao, MatchDao matchDao,
      UserStorageDao userStorageDao) {
    this.locationDao = locationDao;
    this.matchDao = matchDao;
    this.userStorageDao = userStorageDao;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Location> list() {
    //TODO Return Something
  }

  @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Location> search(@RequestParam("q") String fragment) {
    //TODO Return Something
  }

  @GetMapping(value = "{sourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Location get(@PathVariable("sourceId") UUID sourceId) {
    //TODO Return Something
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.CREATED)
  public ResponseEntity<Location> post(@RequestBody Location location) {
    //TODO Return something
  }

  @Transactional
  @DeleteMapping(value = "{sourceId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("sourceId") UUID sourceId) {
    Location source = get(sourceId);
    
  }
}
