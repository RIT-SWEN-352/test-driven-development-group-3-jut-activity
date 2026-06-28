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
  @DisplayName("getCapacity returns supplied capacity")
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

  @Test
  @DisplayName("isEmpty returns true for a new stack with supplied capacity")
  void isEmpty_1() {
    final MyStack<Integer> stack = new MyStack<>(16);
    assertTrue(stack.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns true for a new stack with default capacity")
  void isEmpty_2() {
    final MyStack<Integer> stack = new MyStack<>();
    assertTrue(stack.isEmpty());
  }

  @Test
  @DisplayName("size returns 0 for a new stack with supplied capacity")
  void size_1() {
    final MyStack<Integer> stack = new MyStack<>(16);
    assertEquals(0, stack.size());
  }

  @Test
  @DisplayName("size returns 0 for a new stack with default capacity")
  void size_2() {
    final MyStack<Integer> stack = new MyStack<>();
    assertEquals(0, stack.size());
  }
}
