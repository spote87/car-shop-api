package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Shivaji Pote
 **/
@Getter
@Setter
public class CarData {

  private String location;

  @JsonProperty("vehicles")
  private List<Car> cars;

}
