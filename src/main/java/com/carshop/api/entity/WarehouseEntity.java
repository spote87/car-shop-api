package com.carshop.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * This is entity class for holding <em>Warehouses</em> data.
 *
 * @author Shivaji Pote
 **/
@Getter
@Setter
@Entity
@Table(name = "WAREHOUSE")
public class WarehouseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "WAREHOUSE_ID",nullable = false)
  private Long warehouseId;

  @Column(name = "NAME")
  private String name;

  @OneToOne(mappedBy = "wareHouseEntity",cascade = CascadeType.ALL)
  private LocationEntity locationEntity;

  @OneToMany(mappedBy = "wareHouseEntity",cascade = CascadeType.ALL)
  private Set<CarEntity> carEntities;
}
