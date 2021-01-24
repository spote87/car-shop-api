package com.carshop.api.repository;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.entity.WarehouseEntity;
import com.carshop.api.utils.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shivaji Pote
 **/
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest
class WarehouseRepositoryTest {

  @Autowired
  private WarehouseRepository wareHouseRepository;

  @Test
  @Sql("classpath:cars-data.sql")
  public void warehouseRepository_ReturnsListOfWarehousesWithCars() {
    final Iterable<WarehouseEntity> warehouses = wareHouseRepository.findAll();
    assertNotNull(warehouses);
    int counter = 0;
    final Iterator it = warehouses.iterator();
    while (it.hasNext()) {
      final WarehouseEntity warehouseEntity = (WarehouseEntity) it.next();
      assertNotNull(warehouseEntity);
      assertNotNull(warehouseEntity.getName());
      assertNotNull(warehouseEntity.getCarEntities());
      if (warehouseEntity.getWarehouseId() == 1) {
        assertEquals(2, warehouseEntity.getCarEntities().size());
      } else {
        assertEquals(1, warehouseEntity.getCarEntities().size());
      }
      counter++;
    }
    assertEquals(2, counter);
  }

  @Test
  public void warehouseRepository_ReturnsEmptyListWhenNoDataAvailableInDatabase() {
    final Iterable<WarehouseEntity> warehouses = wareHouseRepository.findAll();
    assertNotNull(warehouses);
    assertFalse(warehouses.iterator().hasNext());
  }

  @Test
  public void warehouseRepository_SavesWarehouseDataInDatabase() {
    final WarehouseEntity entity = TestUtil.getWarehouseEntity(100L);
    entity.setLocationEntity(null);
    final Set<CarEntity> carEntitySet = new HashSet<>();
    final CarEntity carEntity = TestUtil.getCarEntity(1l, 100l);
    carEntitySet.add(carEntity);
    entity.setCarEntities(carEntitySet);
    final WarehouseEntity savedEntity = wareHouseRepository.save(entity);
    assertNotNull(savedEntity);
    assertEquals(1, savedEntity.getWarehouseId());
    assertEquals(1, savedEntity.getCarEntities().size());

    final Iterable<WarehouseEntity> warehouse = wareHouseRepository.findAll();
    assertNotNull(warehouse);
    assertNotNull(warehouse.iterator().next());
  }
}
