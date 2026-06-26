package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

  @Test
  @DisplayName("ctor with no argument supplied that defaults capacity to 16")
  void ctor_2() {
    final MyStack<Integer> stack = new MyStack<>();
    assertNotNull(stack);
  }

  @Test
  @DisplayName("getCapacity method returns supplied capacity")
  void getCapacity_1() {
    final MyStack<Integer> stack = new MyStack<>(16);
    assertEquals(16, stack.getCapacity());
  }

  @Test
  @DisplayName("getCapacity returns default capacity")
  void getCapacity_2() {
    final MyStack<Integer> stack = new MyStack<>();
    assertEquals(16, stack.getCapacity());
  }
}
