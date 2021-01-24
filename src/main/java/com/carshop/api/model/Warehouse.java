package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Model class for holding Warehouse's data in service/presentation layer.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
@EqualsAndHashCode
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Warehouse implements Comparable<Warehouse> {

  @JsonProperty("_id")
  private Long warehouseId;

  private String name;

  private Location location;

  @JsonProperty("cars")
  private CarData carData;

  /**
   * This method compares this Warehouse instance with passed {@link Warehouse} instance by it's <em>warehoueId</em>.
   *
   * @param o {@link Warehouse} instance to be compared with
   * @return 0, 1 or -1 based on comparison.
   */
  @Override
  public int compareTo(final Warehouse o) {
    return warehouseId.compareTo(o.getWarehouseId());
  }
}
