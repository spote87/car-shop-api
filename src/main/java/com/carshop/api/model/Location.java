package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

  private String name;

  @JsonProperty("lat")
  private String latitude;

  @JsonProperty("long")
  private String longitude;
}
