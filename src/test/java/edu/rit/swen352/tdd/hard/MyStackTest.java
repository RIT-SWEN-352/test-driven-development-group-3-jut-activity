package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyStack} component.
 */
class MyStackTest {

  @Test
  @DisplayName("ctor with capacity supplied")
  void ctor_1() {
    final MyStack<Integer> stack = new MyStack<>(16);
    assertNotNull(stack);
  }

}
