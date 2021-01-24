package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author Shivaji Pote
 **/
@Getter
@Setter
@EqualsAndHashCode
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

  @JsonProperty("_id")
  private Long warehouseId;

  private String name;

  private Location location;

  @JsonProperty("cars")
  private CarData carData;
}
