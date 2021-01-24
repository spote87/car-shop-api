package com.carshop.api.service;

import com.carshop.api.entity.WarehouseEntity;
import com.carshop.api.model.Car;
import com.carshop.api.model.CarData;
import com.carshop.api.model.Warehouse;
import com.carshop.api.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * Primary implementation of {@link WarehouseService}.
 *
 * @author Shivaji Pote
 **/
@Log4j2
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

  private final WarehouseRepository warehouseRepository;

  @Override
  public Set<Warehouse> getAllWarehouses() {
    final Iterable<WarehouseEntity> warehouseEntities = warehouseRepository.findAll();
    final Set<Warehouse> warehouses = new TreeSet<>();
    warehouseEntities.forEach(warehouseEntity -> {
      final Warehouse.WarehouseBuilder warehouseBuilder = Warehouse.builder();
      warehouseBuilder.warehouseId(warehouseEntity.getWarehouseId());
      warehouseBuilder.name(warehouseEntity.getName());
      warehouseBuilder.location(CarUtils.getLocation(warehouseEntity));
      warehouseBuilder.carData(getCarsData(warehouseEntity));
      warehouses.add(warehouseBuilder.build());
    });
    return warehouses;
  }

  private CarData getCarsData(final WarehouseEntity warehouseEntity) {
    final CarData carData = new CarData();
    carData.setLocation(warehouseEntity.getLocationEntity().getName());
    final Set<Car> cars = new TreeSet<>();
    if (!CollectionUtils.isEmpty(warehouseEntity.getCarEntities())) {
      warehouseEntity.getCarEntities().forEach(carEntity -> cars.add(CarUtils.getCarFromEntity(carEntity)));
    } else {
      log.warn("No cars available in warehouse {}", warehouseEntity.getWarehouseId());
    }
    carData.setCars(cars);
    return carData;
  }

}
