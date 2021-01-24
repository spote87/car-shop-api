package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Model class for holding Cars data in service/presentation layer. Difference between {@link Car} and this class is it
 * * holds some additional data like <em>location</em>, <em>warehouse name</em> etc.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDetails extends Car {

  private String warehouseName;

  private Long warehouseId;

  @JsonProperty("carId")
  private Long id;

  private Location location;

}
