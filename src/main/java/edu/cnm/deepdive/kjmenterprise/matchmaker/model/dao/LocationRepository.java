package edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Location;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, UUID> {

  Location getById(UUID id);


}
