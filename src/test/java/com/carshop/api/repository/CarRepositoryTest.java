package com.carshop.api.repository;

import com.carshop.api.entity.CarEntity;
import com.carshop.api.utils.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shivaji Pote
 **/
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest
class CarRepositoryTest {

  @Autowired
  private CarRepository carRepository;

  @Test
  @Sql("classpath:cars-data.sql")
  public void carRepository_ReturnsListOfCars() {
    final Iterable<CarEntity> cars = carRepository.findAll();
    assertNotNull(cars);
    int counter = 0;
    final Iterator it = cars.iterator();
    while (it.hasNext()) {
      final CarEntity carEntity = (CarEntity) it.next();
      assertNotNull(carEntity);
      assertNotNull(carEntity.getMake());
      assertNotNull(carEntity.getModel());
      counter++;
    }
    assertEquals(3,counter);
  }

  @Test
  @Sql("classpath:cars-data.sql")
  public void finByWarehouseAndCarId_ReturnsRequestedCar(){
    final CarEntity carEntity = carRepository.findWareHouseAndCarId(1l,1l);
    assertNotNull(carEntity);
    assertEquals("NANO",carEntity.getModel());
    assertEquals("TATA",carEntity.getMake());
  }

  @Test
  @Sql("classpath:cars-data.sql")
  public void finByWarehouseAndCarId_ReturnsNullIfCarDoesNotExistInDatabase(){
    final CarEntity carEntity = carRepository.findWareHouseAndCarId(101l,101l);
    assertNull(carEntity);
  }

  @Test
  public void carsRepository_SavesCarsDataInDatabase(){
    final CarEntity entity = TestUtil.getCarEntity(1L,1L);
    final CarEntity savedEntity = carRepository.save(entity);
    assertNotNull(savedEntity);
    assertEquals(1,savedEntity.getCarId());
    assertEquals(1,savedEntity.getWareHouseEntity().getWarehouseId());

    final Iterable<CarEntity> car = carRepository.findAll();
    assertNotNull(car);
    assertNotNull(car.iterator().next());
  }
}
