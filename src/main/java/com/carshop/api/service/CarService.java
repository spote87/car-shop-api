package com.carshop.api.service;

import com.carshop.api.exception.CarNotFoundException;
import com.carshop.api.model.Car;

/**
 * Service interface containing methods to manage Cars.
 *
 * @author Shivaji Pote
 **/
public interface CarService {

  /**
   * This method fetches single <em>Car's</em> data from database by calling respective repository methods.
   *
   * @param carId       id of the car for which data needs to be retrieved
   * @param wareHouseId id of the warehouse where car belongs
   * @return {@link com.carshop.api.model.CarDetails} instance containing Cars data.
   * @throws CarNotFoundException if specified car not found in inventory
   */
  Car getCarDetails(Long carId, Long wareHouseId) throws CarNotFoundException;
}
