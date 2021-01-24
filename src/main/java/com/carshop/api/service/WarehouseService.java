package com.carshop.api.service;

import com.carshop.api.model.Warehouse;

import java.util.Set;

/**
 * Service interface containing methods to manage warehouses.
 *
 * @author Shivaji Pote
 **/
public interface WarehouseService {

  /**
   * This method returns all warehouses data from database by calling respective repository methods.
   *
   * @return set of {@link Warehouse}s
   */
  Set<Warehouse> getAllWarehouses();

}
