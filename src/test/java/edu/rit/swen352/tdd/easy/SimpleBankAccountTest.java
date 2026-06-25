package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.rit.swen352.tdd.easy.SimpleBankAccount;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link SimpleBankAccount} component.
 */
class SimpleBankAccountTest {
    @Test
    void ctor_noArgDefaultsBalanceToZero() {
        SimpleBankAccount account = new SimpleBankAccount();

        assertEquals(0.0f, account.getBalance());
    }
    @Test
    void ctor_initialBalanceSetsBalance() {
        SimpleBankAccount account = new SimpleBankAccount(25.50f);

        assertEquals(25.50f, account.getBalance());
    }
}
