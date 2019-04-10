package edu.cnm.deepdive.kjmenterprise.matchmaker.controller;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.LocationDao;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.UserLocationDao;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.UserStorageDao;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.UserDecision;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(UserDecision.class)
@RequestMapping("/locations")
public class LocationController {

  private LocationDao locationDao;
  private UserLocationDao mUserLocationDao;
  private UserStorageDao userStorageDao;

  @Autowired
  public LocationController(LocationDao locationDao, UserLocationDao userLocationDao,
      UserStorageDao userStorageDao) {
    this.locationDao = locationDao;
    this.mUserLocationDao = userLocationDao;
    this.userStorageDao = userStorageDao;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserDecision> list() {
    return null;
    //TODO Return Something
  }

  @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserDecision> search(@RequestParam("q") String fragment) {
    return null;
    //TODO Return Something
  }

  @GetMapping(value = "{sourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDecision get(@PathVariable("sourceId") UUID sourceId) {
    return null;
    //TODO Return Something
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.CREATED)
  public ResponseEntity<UserDecision> post(@RequestBody UserDecision userDecision) {
    return null;
    //TODO Return something
  }

  @Transactional
  @DeleteMapping(value = "{sourceId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("sourceId") UUID sourceId) {
    UserDecision source = get(sourceId);
    
  }
}
