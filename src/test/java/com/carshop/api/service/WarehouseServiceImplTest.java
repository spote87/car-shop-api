package com.carshop.api.service;

import com.carshop.api.entity.WarehouseEntity;
import com.carshop.api.model.Warehouse;
import com.carshop.api.repository.WarehouseRepository;
import com.carshop.api.utils.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Shivaji Pote
 **/
@ExtendWith(MockitoExtension.class)
class WarehouseServiceImplTest {

  private final WarehouseRepository warehouseRepository = Mockito.mock(WarehouseRepository.class);

  @InjectMocks
  private  WarehouseServiceImpl warehouseService ;

  @Test
  public void getAllWarehouses_ReturnsAllWarehouseDataReturnedByRepository(){
    when(warehouseRepository.findAll()).thenReturn(mockedWarehouses());
    final Set<Warehouse> warehouses = warehouseService.getAllWarehouses();
    assertNotNull(warehouses);
    assertEquals(2,warehouses.size());
  }

  @Test
  public void getAllWarehouses_ReturnsEmptyWarehouseListWhenNoDataAvailable(){
    when(warehouseRepository.findAll()).thenReturn(()-> Collections.emptyIterator());
    final Set<Warehouse> warehouses = warehouseService.getAllWarehouses();
    assertNotNull(warehouses);
    assertEquals(0,warehouses.size());
  }

  private Iterable<WarehouseEntity> mockedWarehouses() {
    return  ()-> Arrays.asList(TestUtil.getWarehouseEntity(1l),TestUtil.getWarehouseEntity(2l)).iterator();
  }

}
