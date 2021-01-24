package com.carshop.api.controller;

import com.carshop.api.exception.CarNotFoundException;
import com.carshop.api.model.CarDetails;
import com.carshop.api.service.CarService;
import com.carshop.api.utils.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.carshop.api.utils.TestUtil.asJsonString;
import static org.mockito.ArgumentMatchers.anyLong;

/**
 * @author Shivaji Pote
 **/
@SpringBootTest
@AutoConfigureMockMvc
class CarsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CarService carService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void getCarDetails_ReturnsCarDetails() throws Exception {
    final CarDetails carDetails= objectMapper.readValue(TestUtil.readFile("car-details-response.json"), CarDetails.class);
    Mockito.when(carService.getCarDetails(anyLong(), anyLong())).thenReturn(carDetails);
    mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/1/car/1").contentType(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string(asJsonString(carDetails)));
  }

  @Test
  public void getCarDetails_ThrowsPlayerNotFoundException() throws Exception {
    Mockito.when(carService.getCarDetails(anyLong(), anyLong())).thenThrow(new CarNotFoundException("Car with id 1 not found in warehouse 1"));
    mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/1/car/1").contentType(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(MockMvcResultMatchers.status().isNotFound())
      .andExpect(MockMvcResultMatchers.content().string("Car with id 1 not found in warehouse 1"));

  }

}
