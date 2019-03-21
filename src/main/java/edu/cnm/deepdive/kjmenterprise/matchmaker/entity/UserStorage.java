package edu.cnm.deepdive.kjmenterprise.matchmaker.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserStorage {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "user_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @Column(nullable = true, updatable = true)
  private String userMessages;

  @Column(nullable = true, length = 4096, updatable = true)
  private String userMatches;

  @Column(nullable = false, updatable = true)
  private Long userPhotos;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUserMessages() {
    return userMessages;
  }

  public void setUserMessages(String userMessages) {
    this.userMessages = userMessages;
  }

  public String getUserMatches() {
    return userMatches;
  }

  public void setUserMatches(String userMatches) {
    this.userMatches = userMatches;
  }

  public Long getUserPhotos() {
    return userPhotos;
  }

  public void setUserPhotos(Long userPhotos) {
    this.userPhotos = userPhotos;
  }
}
