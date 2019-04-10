/**
 * @authors Kanyon Wyman, Michael Sanchez, James Mattos
 * @version 1.0
 */
package edu.cnm.deepdive.kjmenterprise.matchmaker.view;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

public interface FlatMatch {

  UUID getId();

  Set<UUID> getMatches();

  URI getHref();

}
