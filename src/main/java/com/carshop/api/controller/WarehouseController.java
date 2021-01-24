package com.carshop.api.controller;

import com.carshop.api.model.Warehouse;
import com.carshop.api.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Controller class containing endpoints to handle warehouse data.
 *
 * @author Shivaji Pote
 **/
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8000")
public class WarehouseController {

  private final WarehouseService warehouseService;

  /**
   * This endpoint retrieves all warehouses data from database.
   *
   * @return Set of {@link Warehouse}s
   */
  @GetMapping(path = "/warehouses", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Set<Warehouse>> getAllWarehousesData() {
    return ResponseEntity.ok(warehouseService.getAllWarehouses());
  }

}
