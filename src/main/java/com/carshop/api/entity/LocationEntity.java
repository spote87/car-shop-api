package com.carshop.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * This is entity class for holding <em>locations</em> data.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
@Table(name = "LOCATION")
@Entity
public class LocationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "LOCATION_ID",nullable = false)
  private Long locationId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "LOCATION_ID",nullable = false)
  private WarehouseEntity wareHouseEntity;

  @Column(name = "NAME",nullable = false)
  private String name;

  @Column(name = "LONGITUDE",nullable = false)
  private String longitude;

  @Column(name = "LATITUDE")
  private String latitude;
}
