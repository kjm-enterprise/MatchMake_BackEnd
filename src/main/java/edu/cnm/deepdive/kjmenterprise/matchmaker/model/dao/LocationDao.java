package edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.UserDecision;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface LocationDao extends CrudRepository<UserDecision, UUID> {

  Optional<User> findBySourceAndId(User user, UUID uuid);

  @Query(value = "SELECT * FROM quote ORDER BY RANDOM() OFFSET 0 ROWS FETCH NEXT 1 ROW ONLY",
      nativeQuery = true)
  Optional<UserDecision> find();

  List<UserDecision> findAllByTextContainingOrderByTextAsc(String fragment);


}
