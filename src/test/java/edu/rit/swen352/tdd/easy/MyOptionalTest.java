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
}
