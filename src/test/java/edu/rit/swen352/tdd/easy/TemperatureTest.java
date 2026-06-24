package edu.rit.swen352.tdd.easy;

import com.sun.jdi.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link Temperature} component.
 */
class TemperatureTest {
  @Test
  @DisplayName("ctor with value and unit supplied")
  void ctor_1() {
    final Temperature temperature = new Temperature(75.0, Temperature.TemperatureUnit.CELSIUS);
    assertNotNull(temperature);
  }
  @Test
  @DisplayName("ctor with just value supplied")
  void ctor_2() {
    final Temperature temperature = new Temperature(75.0);
    assertNotNull(temperature);
  }
  @Test
  @DisplayName("getValue method returns the temperature value")
  void getValue() {
    final Temperature temperature = new Temperature(75.0, Temperature.TemperatureUnit.CELSIUS);
    assertEquals(0.0, temperature.getValue());
  }
}
