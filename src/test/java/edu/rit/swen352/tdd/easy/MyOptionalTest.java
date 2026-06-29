package edu.rit.swen352.tdd.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the {@link MyOptional} component.
 */
class MyOptionalTest {

  @Test
  @DisplayName("empty returns empty optional")
  void empty_1() {
    MyOptional<String> optional = MyOptional.empty();
    assertNotNull(optional);
  }

  @Test
  @DisplayName("is present returns false")
  void isPresent_1() {
    MyOptional<String> optional = MyOptional.empty();
    assertFalse(optional.isPresent());
  }

  @Test
  @DisplayName("of returns optional with value")
  void of_1() {
    MyOptional<String> optional = MyOptional.of("test");
    assertNotNull(optional);
  }

  @Test
  @DisplayName("throws null pointer exception for null value")
  void of_2() {
    assertThrows(NullPointerException.class, () -> {
      MyOptional.of(null);
    });
  }
}
