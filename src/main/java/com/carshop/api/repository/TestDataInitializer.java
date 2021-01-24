package com.carshop.api.repository;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.entity.LocationEntity;
import com.carshop.api.entity.WarehouseEntity;
import com.carshop.api.model.Warehouse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * This class load test data in database from <em>test-cars-data.json</em> on server startup. This is like loading
 * inventory data for first time.
 *
 * @author Shivaji Pote
 **/
@Component
public class TestDataInitializer {

  @Autowired
  private WarehouseRepository warehouseRepository;

  private final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * This method gets called after bean is created on server startup. It load test data in database.
   *
   * @throws IOException
   */
  @PostConstruct
  public void loadTestData() throws IOException {
    final InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream("test-cars-data.json");
    final Set<Warehouse> warehouses = objectMapper.readValue(file, new TypeReference<Set<Warehouse>>() {
    });
    final Set<WarehouseEntity> warehouseEntities = new HashSet<>();
    warehouses.forEach(warehouse -> {
      final WarehouseEntity warehouseEntity = new WarehouseEntity();
      warehouseEntity.setWarehouseId(warehouse.getWarehouseId());
      warehouseEntity.setName(warehouse.getName());
      warehouseEntity.setLocationEntity(getLocationEntity(warehouse, warehouseEntity));
      warehouseEntity.setCarEntities(getCarEntities(warehouse, warehouseEntity));
      warehouseEntities.add(warehouseEntity);
    });

    warehouseRepository.saveAll(warehouseEntities);

  }

  private Set<CarEntity> getCarEntities(final Warehouse warehouse, final WarehouseEntity warehouseEntity) {
    final Set<CarEntity> cars = new HashSet<>();
    warehouse.getCarData().getCars().forEach(car -> {
      final CarEntity carEntity = new CarEntity();
      carEntity.setPrice(car.getPrice());
      carEntity.setMake(car.getMake());
      carEntity.setModel(car.getModel());
      carEntity.setLicenced(car.isLicensed());
      carEntity.setDateAdded(car.getDateAdded());
      carEntity.setYearModel(car.getYearModel());
      carEntity.setWareHouseEntity(warehouseEntity
      );
      cars.add(carEntity);
    });
    return cars;
  }

  private LocationEntity getLocationEntity(final Warehouse warehouse, final WarehouseEntity warehouseEntity) {
    final LocationEntity locationEntity = new LocationEntity();
    locationEntity.setLongitude(warehouse.getLocation().getLongitude());
    locationEntity.setLatitude(warehouse.getLocation().getLatitude());
    locationEntity.setName(warehouse.getCarData().getLocation());
    locationEntity.setWareHouseEntity(warehouseEntity);
    return locationEntity;
  }

}
