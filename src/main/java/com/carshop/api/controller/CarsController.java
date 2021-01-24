package com.carshop.api.controller;

import com.carshop.api.exception.CarNotFoundException;
import com.carshop.api.model.Car;
import com.carshop.api.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shivaji Pote
 **/
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8000")
public class CarsController {

  private final CarService carService;

  @GetMapping(path = "/warehouse/{warehouseId}/car/{carId}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Car> getCarDetails(@PathVariable final Long warehouseId, @PathVariable final Long carId) throws CarNotFoundException {
    return ResponseEntity.ok(carService.getCarDetails(carId,warehouseId));
  }

}
