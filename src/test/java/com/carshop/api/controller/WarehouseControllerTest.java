package com.carshop.api.controller;

import com.carshop.api.model.Warehouse;
import com.carshop.api.service.WarehouseService;
import com.carshop.api.utils.TestUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static com.carshop.api.utils.TestUtil.asJsonString;
import static org.mockito.Mockito.when;

/**
 * @author Shivaji Pote
 **/
@SpringBootTest
@AutoConfigureMockMvc
class WarehouseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private WarehouseService warehouseService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void getWarehouses_ReturnsListOfAllWarehouses() throws Exception {
    final Set<Warehouse> warehouses = objectMapper.readValue(TestUtil.readFile("warehouse-cars-data.json"), new TypeReference<Set<Warehouse>>() {
    });
    when(warehouseService.getAllWarehouses()).thenReturn(warehouses);
    mockMvc.perform(MockMvcRequestBuilders.get("/warehouses").contentType(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string(asJsonString(warehouses)));
  }
}
