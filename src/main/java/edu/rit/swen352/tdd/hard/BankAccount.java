package edu.rit.swen352.tdd.hard;

/**
 * A Value Object for American monetary values with fixed integer
 * values for dollars and cents.
 */
record Money(int dollars, int cents) {
  public int dollars() {
    return dollars;
  }

  public int cents() {
    return cents;
  }

  public Money {
    if (dollars < 0) {
      throw new IllegalArgumentException("Dollars can't be negative");
    }
    if (cents < 0 || cents > 99) {
      throw new IllegalArgumentException("Cents must be between 0 and 99");
    }
  }
}

/**
 * An American bank account that permits deposits and withdrawals.
 * The balance must never be negative.  The balance must be stored
 * as a {@link Money} value.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor:
 *     <ul>
 *       <li>a ctor that supplies an initial balance, as a {@link Money} value</li>
 *       <li>a no-arg ctor that defaults the initial balance to zero</li>
 *     </ul>
 *   </li>
 *   <li>{@code getBalance()}: returns the current balance</li>
 *   <li>{@code isAccountEmpty()}: queries whether the balance is zero</li>
 *   <li>{@code deposit(amount)}: add a {@link Money} amount to the balance</li>
 *   <li>{@code withdraw(amount)}: subtract a {@link Money} amount from the balance</li>
 *   <li>{@code toString()}: returns a human-friendly representation of the account balance, eg {@code $20.50}</li>
 * </ul>
 */
public class BankAccount {}
