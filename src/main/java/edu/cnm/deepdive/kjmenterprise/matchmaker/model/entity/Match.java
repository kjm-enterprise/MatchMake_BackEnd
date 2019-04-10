/**
 * @authors Kanyon Wyman, Michael Sanchez, James Mattos
 * @version 1.0
 */
package edu.cnm.deepdive.kjmenterprise.matchmaker.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.kjmenterprise.matchmaker.view.FlatMatch;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

@Entity
public class Match implements FlatMatch {

  /**
   * Reaction enum to determine whether 2 matches are matched, not matched, or haven't seen each other
   */

  private enum Reactions {
    POSITIVE,
    NEUTRAL,
    NEGATIVE,
  }

  private static EntityLinks entityLinks;


  /**
   * Creates uuid for the user
   */

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "match_id",  nullable = false, updatable = false)
  private UUID id;

  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Fetches matches and turns them into Json format
   */

  @JsonSerialize(contentAs = FlatMatch.class)
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "matches", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("text ASC")
  private Set<Match> matches = new LinkedHashSet<>();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public Set<UUID> getMatches() {
    return null;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Match.class, id).toUri();
  }

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Match.entityLinks = entityLinks;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  //TODO Implement Match in logic
}
