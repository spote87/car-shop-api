package com.carshop.api.controller;
import com.carshop.api.exception.CarNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is exception handler for Car Shop application. It contains Exception
 * handlers for different exception.
 *
 * @author Shivaji Pote
 */
@ControllerAdvice
@Log4j2
public class CarShopErrorHandler {

  /**
   * Exception handler for {@link com.carshop.api.exception.CarNotFoundException}.
   *
   * @param exception {@code CarNotFoundException} instance
   * @return {@link ResponseEntity} containing http status and error message
   */
  @ExceptionHandler(CarNotFoundException.class)
  public ResponseEntity<String> handlePlayerNotFoundException(final CarNotFoundException exception) {
    log.error(exception.getMessage(), exception);
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

}
