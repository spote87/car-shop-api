package com.carshop.api.service;

import com.carshop.api.exception.CarNotFoundException;
import com.carshop.api.model.Car;
import com.carshop.api.repository.CarRepository;
import com.carshop.api.utils.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author Shivaji Pote
 **/
@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

  private final CarRepository carRepository = Mockito.mock(CarRepository.class);

  @InjectMocks
  private CarServiceImpl carService;

  @Test
  public void getCar_ReturnsCarDetailsReturnedByRepository() throws CarNotFoundException {
    when(carRepository.findWareHouseAndCarId(anyLong(), anyLong())).thenReturn(TestUtil.getCarEntity(1l, 1l));
    final Car car = carService.getCarDetails(1l, 1l);
    assertNotNull(car);
    assertEquals("Nano",car.getModel());
    assertEquals("Tata",car.getMake());
  }

  @Test
  public void getCar_ThrowsCarNotFoundExceptionWhenCarIsNotAvailable(){
    when(carRepository.findWareHouseAndCarId(anyLong(),anyLong())).thenReturn(null);
    assertThrows(CarNotFoundException.class, ()-> carService.getCarDetails(1l,1l));
  }

}
