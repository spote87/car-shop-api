package com.carshop.api.service;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.entity.LocationEntity;
import com.carshop.api.entity.WarehouseEntity;
import com.carshop.api.model.Car;
import com.carshop.api.model.CarDetails;
import com.carshop.api.model.Location;

/**
 * @author Shivaji Pote
 **/
public class CarUtils {

  public static Car getCarFromEntity(final CarEntity carEntity) {
    final Car car = new Car();
    updateCarData(carEntity, car);
    return car;
  }

  public static CarDetails getCarDetailsFromEntity(final CarEntity carEntity) {
    final CarDetails car = new CarDetails();
    updateCarData(carEntity, car);
    car.setLocation(getLocation(carEntity.getWareHouseEntity()));
    car.setWarehouseId(carEntity.getWareHouseEntity().getWarehouseId());
    car.setWarehouseId(carEntity.getWareHouseEntity().getWarehouseId());
    return car;
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

  public static Location getLocation(final WarehouseEntity warehouseEntity) {
    final Location location = new Location();
    final LocationEntity locationEntity = warehouseEntity.getLocationEntity();
    location.setName(locationEntity.getName());
    location.setLongitude(locationEntity.getLongitude());
    location.setLatitude(locationEntity.getLatitude());
    return location;
  }
}
