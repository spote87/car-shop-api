package com.carshop.api.service;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.exception.CarNotFoundException;
import com.carshop.api.model.Car;
import com.carshop.api.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shivaji Pote
 **/
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

  private final CarRepository carRepository;

  @Override
  public Car getCarDetails(final Long carId, final Long wareHouseId) throws CarNotFoundException {
    final CarEntity carEntity = carRepository.findWareHouseAndCarId(wareHouseId,carId);
    if(carEntity == null) {
      final StringBuilder messageBuilder = new StringBuilder();
      messageBuilder.append("Car with id ").append(carId).append(" does not exist in warehouse ").append(wareHouseId);
      throw  new CarNotFoundException(messageBuilder.toString());
    }
    return CarUtils.getCarDetailsFromEntity(carEntity);
  }

}
