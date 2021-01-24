package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Shivaji Pote
 **/
@Getter
@Setter
public class CarDetails extends Car {

  private String warehouseName;

  private Long warehouseId;

  @JsonProperty("carId")
  private Long id;

  private Location location;

}
