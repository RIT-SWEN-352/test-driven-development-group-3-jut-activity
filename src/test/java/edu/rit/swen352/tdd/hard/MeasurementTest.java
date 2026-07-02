package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link Measurement} component.
 */
class MeasurementTest {
    @ParameterizedTest
    @CsvSource({
        "100.0, cm, 1.0, m",
        "1.0, m, 100.0, cm",
        "1.0, ft, 12.0, in",
        "1.0, mi, 1.609344, km",
        "1.0, km, 1000.0, m"
    })
    void convertTo_lengthUnitsConvertsCorrectly(
        double originalValue,
        String originalUnits,
        double expectedValue,
        String targetUnits
    ) {
        Measurement measurement = new Measurement(originalValue, originalUnits);

        Measurement converted = measurement.convertTo(targetUnits);

        assertAll(
            () -> assertEquals(expectedValue, converted.getValue(), 0.0001),
            () -> assertEquals(targetUnits, converted.getUnits())
        );
    }
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
    @Test
    void convertTo_sameUnitsReturnsEquivalentMeasurement() {
        Measurement measurement = new Measurement(5.0, "m");

        Measurement converted = measurement.convertTo("m");

        assertAll(
            () -> assertEquals(5.0, converted.getValue()),
            () -> assertEquals("m", converted.getUnits()),
            () -> assertNotSame(measurement, converted)
        );
    }
    @Test
    void convertTo_inchesToCentimeters() {
        Measurement measurement = new Measurement(1.0, "in");

        Measurement converted = measurement.convertTo("cm");

        assertAll(
            () -> assertEquals(2.54, converted.getValue(), 0.0001),
            () -> assertEquals("cm", converted.getUnits())
        );
    }
    @ParameterizedTest
    @CsvSource({
        "60.0, s, 1.0, min",
        "1.0, min, 60.0, s",
        "1.0, hr, 60.0, min",
        "3600.0, s, 1.0, hr"
    })
    void convertTo_timeUnitsConvertsCorrectly(
        double originalValue,
        String originalUnits,
        double expectedValue,
        String targetUnits
    ) {
        Measurement measurement = new Measurement(originalValue, originalUnits);

        Measurement converted = measurement.convertTo(targetUnits);

        assertAll(
            () -> assertEquals(expectedValue, converted.getValue(), 0.0001),
            () -> assertEquals(targetUnits, converted.getUnits())
        );
    }
    @ParameterizedTest
    @CsvSource({
        "1000.0, g, 1.0, kg",
        "1.0, kg, 1000.0, g",
        "1.0, lb, 0.45359237, kg",
        "1.0, kg, 2.20462262, lb"
    })
    void convertTo_massUnitsConvertsCorrectly(
        double originalValue,
        String originalUnits,
        double expectedValue,
        String targetUnits
    ) {
        Measurement measurement = new Measurement(originalValue, originalUnits);

        Measurement converted = measurement.convertTo(targetUnits);

        assertAll(
            () -> assertEquals(expectedValue, converted.getValue(), 0.0001),
            () -> assertEquals(targetUnits, converted.getUnits())
        );
    }
    @Test
    void convertTo_incompatibleUnitsThrowsException() {
        Measurement measurement = new Measurement(5.0, "m");

        assertThrows(
            IllegalArgumentException.class,
            () -> measurement.convertTo("s")
        );
    }
    @Test
    void add_sameUnitsAddsValues() {
        Measurement left = new Measurement(5.0, "m");
        Measurement right = new Measurement(3.0, "m");

        Measurement result = left.add(right);

        assertAll(
            () -> assertEquals(8.0, result.getValue(), 0.0001),
            () -> assertEquals("m", result.getUnits())
        );
    }
    @Test
    void add_compatibleUnitsConvertsArgumentBeforeAdding() {
        Measurement left = new Measurement(1.0, "m");
        Measurement right = new Measurement(100.0, "cm");

        Measurement result = left.add(right);

        assertAll(
            () -> assertEquals(2.0, result.getValue(), 0.0001),
            () -> assertEquals("m", result.getUnits())
        );
    }
    @Test
    void add_incompatibleUnitsThrowsException() {
        Measurement left = new Measurement(5.0, "m");
        Measurement right = new Measurement(3.0, "s");

        assertThrows(
            IllegalArgumentException.class,
            () -> left.add(right)
        );
    }
}
