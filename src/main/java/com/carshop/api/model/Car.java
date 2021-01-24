package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Model class for holding Car's data in service/presentation layer.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
@EqualsAndHashCode
public class Car implements Comparable<Car> {

  @JsonProperty("_id")
  private Long carId;

  private String make;

  private String model;

  @JsonProperty("date_added")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateAdded;

  @JsonProperty("year_model")
  private int yearModel;

  private BigDecimal price;

  private boolean licensed;

  /**
   * This method compares this car instance with passed {@link Car} instance by it's <em>carId</em>.
   *
   * @param o {@link Car} instance to be compared with
   * @return 0, 1 or -1 based on comparison.
   */
  @Override
  public int compareTo(final Car o) {
    return carId.compareTo(o.getCarId());
  }
}
