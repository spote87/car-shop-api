package com.carshop.api.exception;

/**
 * Exception class for handling car not found error.
 *
 * @author Shivaji Pote
 **/
public class CarNotFoundException extends Exception {

  private static final long serialVersionUID = -7661232270464790888L;

  /**
   * {@link CarNotFoundException} constructor.
   *
   * @param message error message
   */
  public CarNotFoundException(final String message) {
    super(message);
  }

}
