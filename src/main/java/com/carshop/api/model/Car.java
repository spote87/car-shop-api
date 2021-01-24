package com.carshop.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Shivaji Pote
 **/
@Getter
@Setter
@EqualsAndHashCode
public class Car {

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

}
