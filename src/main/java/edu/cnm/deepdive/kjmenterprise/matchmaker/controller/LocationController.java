package edu.cnm.deepdive.kjmenterprise.matchmaker.controller;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.LocationRepository;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.MatchRepository;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao.UserStorageRepository;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Location;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Location.class)
@RequestMapping("/locations")
public class LocationController {

  private LocationRepository locationRepository;
  private MatchRepository matchRepository;
  private UserStorageRepository userStorageRepository;

}



