package com.carshop.api.utils;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.entity.LocationEntity;
import com.carshop.api.entity.WarehouseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Shivaji Pote
 **/
public class TestUtil {

  public static InputStream readFile(final String file) {
    return Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
  }

  /*
   * converts a Java object into JSON representation
   */
  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static CarEntity getCarEntity(final Long carId, final Long wareHouseId) {
    final CarEntity entity = new CarEntity();
    entity.setCarId(carId);
    entity.setWareHouseEntity(getWarehouseEntity(wareHouseId));
    entity.setDateAdded(new Date());
    entity.setLicenced(true);
    entity.setModel("Nano");
    entity.setMake("Tata");
    entity.setPrice(new BigDecimal(100000.00));
    return entity;
  }

  public static WarehouseEntity getWarehouseEntity(final Long wareHouseId) {
    final WarehouseEntity entity = new WarehouseEntity();
    entity.setLocationEntity(getLocationEntity());
    entity.setWarehouseId(wareHouseId);
    entity.setName("Warehouse A");
    return entity;
  }

  public static LocationEntity getLocationEntity() {
    final LocationEntity entity = new LocationEntity();
    entity.setLocationId(1L);
    entity.setLongitude("12345.99");
    entity.setLatitude("232323.44");
    entity.setName("Pune, India");
    return entity;
  }
}
