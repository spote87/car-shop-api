package com.carshop.api.exception;

/**
 * @author Shivaji Pote
 **/
public class CarNotFoundException extends Exception {

  private static final long serialVersionUID = -7661232270464790888L;

  public CarNotFoundException(final String message) {
    super(message);
  }

}
