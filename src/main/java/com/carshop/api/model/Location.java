package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Model class for holding location data in service/presentation layer.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
@JsonIgnoreProperties("name")
public class Location {

  private String name;

  @JsonProperty("lat")
  private String latitude;

  @JsonProperty("long")
  private String longitude;
}
