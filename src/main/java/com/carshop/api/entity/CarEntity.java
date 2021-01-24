package com.carshop.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Shivaji Pote
 **/
@Getter
@Setter
@Entity
@Table(name = "CAR")
public class CarEntity implements Serializable {

  private static final long serialVersionUID = 1452833464422592509L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CAR_ID", nullable = false)
  private Long carId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "WAREHOUSE_ID",nullable = false)
  private WarehouseEntity wareHouseEntity;

  @Column(name = "MAKE", nullable = false)
  private String make;

  @Column(name = "MODEL", nullable = false)
  private String model;

  @Column(name = "YEAR_MODEL")
  private int yearModel;

  @Column(name = "PRICE",nullable = false)
  private BigDecimal price;

  @Column(name = "LICENCED",nullable = false)
  private boolean licenced;

  @Column(name = "DATE_ADDED",nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dateAdded;

}
