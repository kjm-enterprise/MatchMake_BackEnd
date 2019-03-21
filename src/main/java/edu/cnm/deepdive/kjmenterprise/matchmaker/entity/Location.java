package edu.cnm.deepdive.kjmenterprise.matchmaker.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

public class Location {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "location_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @Column(nullable = false, updatable = false)
  private String city;

  @Column(nullable = false, updatable = true)
  private Long zipCode;

  @Column(nullable = false, updatable = true)
  private String locationName;

  @Column(nullable = false, updatable = true)
  private Long  latitude;

  @Column(nullable = false, updatable = true)
  private Long longitude;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.DATE)
  @Column(nullable = false, updatable = false)
  private Date date;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Long getZipCode() {
    return zipCode;
  }

  public void setZipCode(Long zipCode) {
    this.zipCode = zipCode;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public Long getLatitude() {
    return latitude;
  }

  public void setLatitude(Long latitude) {
    this.latitude = latitude;
  }

  public Long getLongitude() {
    return longitude;
  }

  public void setLongitude(Long longitude) {
    this.longitude = longitude;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
