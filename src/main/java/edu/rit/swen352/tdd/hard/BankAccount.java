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

  public Money add(Money other) {
    int totalCents = this.cents + other.cents;
    int carryOver = totalCents / 100;
    int newCents = totalCents % 100;
    int newDollars = this.dollars + other.dollars + carryOver;
    return new Money(newDollars, newCents);
  }

  public Money subtract(Money other) {
    if (
      this.dollars < other.dollars || (this.dollars == other.dollars && this.cents < other.cents)
    ) {
      throw new IllegalArgumentException("Insufficient funds");
    }

    int totalCents1 = this.dollars * 100 + this.cents;
    int totalCents2 = other.dollars * 100 + other.cents;
    int resultCents = totalCents1 - totalCents2;

    return new Money(resultCents / 100, resultCents % 100);
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
public class BankAccount {

  private Money balance;

  public BankAccount(Money initialBalance) {
    this.balance = initialBalance;
  }

  public BankAccount() {
    this(new Money(0, 0));
  }

  public Money getBalance() {
    return balance;
  }

  public boolean isAccountEmpty() {
    return balance.dollars() == 0 && balance.cents() == 0;
  }

  public void deposit(Money amount) {
    this.balance = this.balance.add(amount);
  }

  public void withdraw(Money amount) {
    if (
      amount.dollars() > balance.dollars() ||
      (amount.dollars() == balance.dollars() && amount.cents() > balance.cents())
    ) {
      throw new IllegalStateException("Insufficient funds");
    }
    this.balance = this.balance.subtract(amount);
  }
}
