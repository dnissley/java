package com.dnissley.ctci.chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayStackTest {
  @Test
  public void firstPushesThenPopsReturnCorrectValues() throws Exception {
    ArrayStack<String> s = new ArrayStack<>();
    s.push("a");
    assertEquals("a", s.peek());
    s.push("b");
    assertEquals("b", s.peek());
    s.push("c");
    assertEquals("c", s.peek());
    s.push("d");
    assertEquals("d", s.peek());
    assertEquals("d", s.pop());
    assertEquals("c", s.pop());
    assertEquals("b", s.pop());
    assertEquals("a", s.pop());
  }

  @Test
  public void mixOfPushesAndPopsReturnCorrectValues() throws Exception {
    ArrayStack<String> s = new ArrayStack<>();
    s.push("^");
    assertEquals("^", s.peek());
    s.pop();
    s.push("h");
    s.push("-");
    assertEquals("-", s.peek());
    s.pop();
    assertEquals("h", s.peek());
    s.push("e");
    s.push("l");
    assertEquals("l", s.peek());
    s.push("l");
    s.push("*");
    s.pop();
    assertEquals("l", s.peek());
    s.push("o");
    s.push("!");
    s.pop();
    assertEquals("o", s.peek());
    assertEquals("o", s.pop());
    assertEquals("l", s.pop());
    assertEquals("l", s.pop());
    assertEquals("e", s.pop());
    assertEquals("h", s.pop());
  }

  @Test
  public void largeStackWorksAsExpected() throws Exception {
    ArrayStack<String> s = new ArrayStack<>(2);
    for (int i = 0; i < 100; i++) {
      s.push(Integer.toString(i));
      assertEquals(Integer.toString(i), s.peek());
    }
    for (int i = 99; i >= 0; i--) {
      assertEquals(Integer.toString(i), s.peek());
      assertEquals(Integer.toString(i), s.pop());
    }
  }

  @Test
  public void isEmptyReturnsTrueIfEmptyAndFalseOtherwise() throws Exception {
    ArrayStack<String> s = new ArrayStack<>();
    assertTrue(s.isEmpty());
    s.push("a");
    assertFalse(s.isEmpty());
    s.push("b");
    assertFalse(s.isEmpty());
    s.pop();
    assertFalse(s.isEmpty());
    s.pop();
    assertTrue(s.isEmpty());
  }

  @Test
  public void peekReturnsCorrectValue() throws Exception {
    ArrayStack<String> s = new ArrayStack<>();
    s.push("hello");
    s.push("world");
    assertEquals("world", s.peek());
  }

  @Test(expected = Exception.class)
  public void peekOnEmptyStackThrowsException() throws Exception {
    ArrayStack<String> s = new ArrayStack<>();
    s.peek();
  }

  @Test(expected = Exception.class)
  public void popOnEmptyStackThrowsException() throws Exception {
    ArrayStack<String> s = new ArrayStack<>();
    s.pop();
  }
}

