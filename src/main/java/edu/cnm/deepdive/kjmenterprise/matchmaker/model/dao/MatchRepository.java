/**
 * @authors Kanyon Wyman, Michael Sanchez, James Mattos
 * @version 1.0
 */
package edu.cnm.deepdive.kjmenterprise.matchmaker.model.dao;

import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.Match;
import edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity.UserStorage;
import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, UUID> {

  Iterable<Match> findAllByOrderByTextAsc();
  Iterable<Match> findAllByTextContainingOrderByTextAsc(String fragment);

  @Query (value = "SELECT * FROM Users ORDER BY id",
  countQuery = "SELECT count(*) FROM Users",
  nativeQuery = true)
  Page<UserStorage> findAllUsersWithPagination(Pageable pageable);
  Optional<Match> findRandom();
}
