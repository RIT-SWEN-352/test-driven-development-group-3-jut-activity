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
  @Test
  @DisplayName("getUnit method returns the temperature unit")
  void getUnit() {
    final Temperature temperature = new Temperature(75.0, Temperature.TemperatureUnit.CELSIUS);
    assertEquals(Temperature.TemperatureUnit.CELSIUS, temperature.getUnit());
  }
  @Test
  @DisplayName("convertTo method creates a new Temperature in the new unit")
  void convertTo() {
    final Temperature temperature = new Temperature(75.0, Temperature.TemperatureUnit.CELSIUS);
    final Temperature convertedTemperature = temperature.convertTo(Temperature.TemperatureUnit.CELSIUS);
    assertEquals(75.0, convertedTemperature.getValue());
    assertEquals(Temperature.TemperatureUnit.CELSIUS, convertedTemperature.getUnit());
  }
  @Test
  @DisplayName("toString method converts returns a human_friendly representation of the temperature")
  void toString_() {
    final Temperature temperature = new Temperature(25.0, Temperature.TemperatureUnit.CELSIUS);
    assertEquals("25.0 C", temperature.toString());
  }
}
