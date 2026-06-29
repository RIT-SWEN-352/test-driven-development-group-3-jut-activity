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
}
