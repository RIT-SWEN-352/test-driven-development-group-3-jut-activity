package edu.rit.swen352.tdd.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the {@link MyOptional} component.
 */
class MyOptionalTest {

  @Test
  @DisplayName("empty returns empty optional")
  void empty_1() {
    MyOptional<String> optional = MyOptional.empty();
    assertNotNull(optional);
  }

  @Test
  @DisplayName("is present returns presence")
  void isPresent_1() {
    MyOptional<String> optional = MyOptional.empty();
    assertFalse(optional.isPresent());
  }

  @Test
  @DisplayName("of returns optional with value")
  void of_1() {
    MyOptional<String> optional = MyOptional.of("test");
    assertNotNull(optional);
  }

  @Test
  @DisplayName("throws null pointer exception for null value")
  void of_2() {
    assertThrows(NullPointerException.class, () -> {
      MyOptional.of(null);
    });
  }

  @Test
  @DisplayName("non null returns optional with value")
  void ofNullable_1() {
    MyOptional<String> optional = MyOptional.ofNullable("test");
    assertTrue(optional.isPresent());
  }

  @Test
  @DisplayName("null returns optional without value present")
  void ofNullable_2() {
    MyOptional<String> optional = MyOptional.ofNullable(null);
    assertFalse(optional.isPresent());
  }

  @Test
  @DisplayName("return option value")
  void get_1() {
    MyOptional<String> optional = MyOptional.of("test");
    assertEquals("test", optional.get());
  }

  @Test
  @DisplayName("throws no such element exception when empty")
  void get_2() {
    MyOptional<String> optional = MyOptional.empty();
    assertThrows(NoSuchElementException.class, optional::get);
  }

  @Test
  @DisplayName("if value present execute consumer")
  void ifPresentConsumer_1() {
    AtomicBoolean executed = new AtomicBoolean(false);
    MyOptional<String> optional = MyOptional.of("test");

    optional.ifPresent(str -> executed.set(true));

    assertTrue(executed.get());
  }
}
