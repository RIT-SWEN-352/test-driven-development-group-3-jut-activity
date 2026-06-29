package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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

  @Test
  @DisplayName("push adds one element onto an empty stack")
  void push_1() {
    final MyStack<Integer> stack = new MyStack<>(16);
    stack.push(5);
    assertAll(
      () -> assertEquals(1, stack.size()),
      () -> assertFalse(stack.isEmpty())
    );
  }

  @Test
  @DisplayName("push adds multiple elements onto an empty stack")
  void push_2() {
    final MyStack<Integer> stack = new MyStack<>(16);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    assertAll(
      () -> assertEquals(3, stack.size()),
      () -> assertFalse(stack.isEmpty())
    );
  }

  @Test
  @DisplayName("push adds elements until capacity is reached")
  void push_3() {
    final MyStack<Integer> stack = new MyStack<>(5);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(9);
    assertEquals(5, stack.size());
  }

  @Test
  @DisplayName("push throws IllegalStateException if stack is full")
  void push_4() {
    final MyStack<Integer> stack = new MyStack<>(5);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(9);
    assertThrows(IllegalStateException.class, () -> stack.push(7));
  }

  @Test
  @DisplayName("pop throws NoSuchElementException when stack is empty")
  void pop_1() {
    final MyStack<Integer> stack = new MyStack<>(5);
    assertThrows(NoSuchElementException.class, stack::pop);
  }

  @Test
  @DisplayName("pop returns the element in the stack")
  void pop_2() {
    final MyStack<Integer> stack = new MyStack<>(5);
    stack.push(5);
    assertEquals(5, stack.pop());
  }

  @Test
  @DisplayName("pop updates the stack size")
  void pop_3() {
    final MyStack<Integer> stack = new MyStack<>(5);
    stack.push(5);
    stack.pop();
    assertEquals(0, stack.size());
  }

  @Test
  @DisplayName("pop declares stack empty after removing last/only element")
  void pop_4() {
    final MyStack<Integer> stack = new MyStack<>(5);
    stack.push(5);
    stack.pop();
    assertTrue(stack.isEmpty());
  }
}
