package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Model class for holding Cars data in service/presentation layer. Difference between {@link Car} and this class is it
 * holds some additional data like <em>location</em>.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
public class CarData {

  private String location;

  @JsonProperty("vehicles")
  private Set<Car> cars;

}
