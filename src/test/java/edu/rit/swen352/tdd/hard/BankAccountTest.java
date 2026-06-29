package edu.rit.swen352.tdd.hard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the {@link BankAccount} component.
 */
class BankAccountTest {

  @Test
  @DisplayName("money should hold dollars and cents")
  void money_1() {
    Money money = new Money(10, 50);
    assertEquals(10, money.dollars());
    assertEquals(50, money.cents());
  }

  @Test
  @DisplayName("money should make sure dollars and cents are non-negative and conforming")
  void money_2() {
    assertThrows(IllegalArgumentException.class, () -> new Money(10, 100));
    assertThrows(IllegalArgumentException.class, () -> new Money(10, -1));
    assertThrows(IllegalArgumentException.class, () -> new Money(-1, 50));
  }

  @Test
  @DisplayName("money should add values")
  void money_3() {
    Money m1 = new Money(10, 50);
    Money m2 = new Money(5, 75);
    Money result = m1.add(m2);

    assertEquals(16, result.dollars());
    assertEquals(25, result.cents());
  }

  @Test
  @DisplayName("money should subtract values")
  void money_4() {
    Money m1 = new Money(10, 25);
    Money m2 = new Money(5, 50);
    Money result = m1.subtract(m2);

    assertEquals(4, result.dollars());
    assertEquals(75, result.cents());
  }

  @Test
  @DisplayName("money throws exception for illegal substraction")
  void money_5() {
    Money m1 = new Money(5, 25);
    Money m2 = new Money(10, 50);

    assertThrows(IllegalArgumentException.class, () -> m1.subtract(m2));
  }

  @Test
  @DisplayName("ctor with balance")
  void ctor_1() {
    Money initialBalance = new Money(100, 50);
    BankAccount account = new BankAccount(initialBalance);

    assertEquals(initialBalance, account.getBalance());
  }
}
