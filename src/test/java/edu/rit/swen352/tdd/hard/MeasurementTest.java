package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link Measurement} component.
 */
class MeasurementTest {
    @Test
    void ctor_valueAndUnitsCreatesMeasurement() {
        Measurement measurement = new Measurement(9.8, "m/s^2");

        assertAll(
            () -> assertEquals(9.8, measurement.getValue()),
            () -> assertEquals("m/s^2", measurement.getUnits())
        );
    }
    @Test
    void toString_formatsValueAndUnits() {
        Measurement measurement = new Measurement(9.8, "m/s^2");

        assertEquals("9.8m/s^2", measurement.toString());
    }
    @Test
    void ctor_nullUnitsThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Measurement(10.0, null)
        );
    }
    void ctor_blankUnitsThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Measurement(10.0, " ")
        );
    }
}
