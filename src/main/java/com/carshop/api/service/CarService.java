package com.carshop.api.service;

import com.carshop.api.exception.CarNotFoundException;
import com.carshop.api.model.Car;

/**
 * @author Shivaji Pote
 **/
public interface CarService {

  Car getCarDetails(Long carId, Long wareHouseId) throws CarNotFoundException;
}
