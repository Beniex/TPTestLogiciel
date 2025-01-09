package com.unitTesting.helloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloTest {

  @Test
  public void testMessageWhenPrenomNullThrowsIllegalArgumentException() {
    Hello prenomNull = new Hello();
    Exception exceptionCatched = assertThrows(IllegalArgumentException.class, () -> prenomNull.message(null));
    assertEquals("il n'y a pas de prénom", exceptionCatched.getMessage());
  }

  @Test
  public void testMessageWhenPrenomNotNull() {
    Hello prenomNotNull = new Hello();
    assertEquals("Hello Benoit !", prenomNotNull.message("Benoit"));
  }
}
