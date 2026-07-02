package edu.rit.swen352.tdd.hard;

/**
 * A Measurement is a numeric value with a unit of measure.
 * Examples: 100kg, 5280ft, 47m^2, 55mph, and 9.8m/s^2.
 *
 * <p>
 *   The types of units must include length, time, and mass.
 *   Each type of unit must support multiple specific units,
 *   such as kilometers, miles, meters, feet, centimeters, and inches.
 *   You need to be able to convert between units,
 *   such as <strong>an inch is 2.54cm</strong>.
 *   Likewise for the other types of units: time and mass.
 * </p>
 *
 * <p>
 *   This must be an immutable
 *   <a href='https://en.wikipedia.org/wiki/Value_object'>Value Object</a>.
 *   Arithmetic operations must create new instances.
 * </p>
 *
 * <p>
 *   This component must support complex units, such as miles/hour, m/s^2,
 *   kg-m/s^2, and so on.  The component must support units of length, time, and mass;
 *   in a variety of combinations.
 * </p>
 *
 * <p>
 *   The component must support conversions (ft to meters or mi/hr to km/sec),
 *   and basic arithmetic operations: addition, subtraction, multiplication,
 *   and division <em>(optional)</em>.
 * </p>
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor: a ctor that supplies both the value, as a {@code double}, and units</li>
 *   <li>{@code getValue()}: return the value of the measurement</li>
 *   <li>{@code getUnits()}: return the units of the measurement</li>
 *   <li>{@code toString()}: returns a human-friendly representation, eg "9.8m/s^2"</li>
 *   <li>conversion: convert the measurement to a new set of compatible units</li>
 *   <li>{@code addition(X)}: add two measurements {@code (this + X)}
 *     <ul>
 *       <li>throw an exception if the units do not match</li>
 *       <li>handle conversion of the argument to the {@code this} units</li>
 *     </ul>
 *   </li>
 *   <li>{@code substraction(X)}: subtract two measurements {@code (this - X)}
 *     <ul>
 *       <li>throw an exception if the units do not match</li>
 *       <li>handle conversion of the argument to the {@code this} units</li>
 *     </ul>
 *   </li>
 *   <li>{@code multiplication(X)}: multiple a measurement by X {@code this * X}
 *     <ul>
 *       <li>case: X is a scalar ({@code double})</li>
 *       <li>case: X is another measurement with same or different units</li>
 *     </ul>
 *   </li>
 *   <li>{@code division(X)}: divide a measurement by X {@code this / X}
 *     <ul>
 *       <li>case: X is a scalar ({@code double})</li>
 *       <li>case: X is another measurement with same units: results in a scalar (a Measurement with no units)</li>
 *       <li>case: X is another measurement with different units</li>
 *     </ul>
 *     <p><em>NOTE:</em> if you run out of time, then skip the division operation</p>
 *   </li>
 * </ul>
 *
 */
public class Measurement {

    private final double value;
    private final String units;

    public Measurement(double value, String units) {
        if (units == null) {
            throw new IllegalArgumentException("Units cannot be null.");
        }
        if (units.isBlank()) {
            throw new IllegalArgumentException("Units cannot be blank.");
        }

        this.value = value;
        this.units = units;
    }

    public double getValue() {
        return value;
    }

    public String getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return value + units;
    }

    public Measurement convertTo(String targetUnits) {
        assert false : "NYI";
        return null;
    }
}
