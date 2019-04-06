package edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.UserStorage;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserStorageRepository extends CrudRepository<UserStorage, UUID> {
  UserStorage getById(UUID id);
}
