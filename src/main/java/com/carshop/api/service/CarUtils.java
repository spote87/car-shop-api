package com.carshop.api.service;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.entity.LocationEntity;
import com.carshop.api.entity.WarehouseEntity;
import com.carshop.api.model.Car;
import com.carshop.api.model.CarDetails;
import com.carshop.api.model.Location;

/**
 * Utility class for manipulating Cars data.
 *
 * @author Shivaji Pote
 **/
public class CarUtils {

  /**
   * This method converts Car entity into {@link Car} instance.
   *
   * @param carEntity car entity
   * @return {@link Car} instance
   */
  public static Car getCarFromEntity(final CarEntity carEntity) {
    final Car car = new Car();
    updateCarData(carEntity, car);
    return car;
  }

  /**
   * This method converts Car entity into {@link CarDetails} instance.
   *
   * @param carEntity car entity
   * @return {@link CarDetails} instance
   */
  public static CarDetails getCarDetailsFromEntity(final CarEntity carEntity) {
    final CarDetails car = new CarDetails();
    updateCarData(carEntity, car);
    car.setLocation(getLocation(carEntity.getWareHouseEntity()));
    car.setWarehouseName(carEntity.getWareHouseEntity().getName());
    car.setWarehouseId(carEntity.getWareHouseEntity().getWarehouseId());
    return car;
  }

  /**
   * This method retrieves location from warehouse entity.
   *
   * @param warehouseEntity warehouse entity
   * @return {@link Location} instance
   */
  public static Location getLocation(final WarehouseEntity warehouseEntity) {
    final Location location = new Location();
    final LocationEntity locationEntity = warehouseEntity.getLocationEntity();
    location.setName(locationEntity.getName());
    location.setLongitude(locationEntity.getLongitude());
    location.setLatitude(locationEntity.getLatitude());
    return location;
  }

  private static void updateCarData(final CarEntity carEntity, final Car car) {
    car.setCarId(carEntity.getCarId());
    car.setDateAdded(carEntity.getDateAdded());
    car.setLicensed(carEntity.isLicenced());
    car.setMake(carEntity.getMake());
    car.setModel(carEntity.getModel());
    car.setPrice(carEntity.getPrice());
    car.setYearModel(carEntity.getYearModel());
  }

  private CarUtils() throws InstantiationException {
    throw new InstantiationException("Cannot instantiate this class");
  }

}
