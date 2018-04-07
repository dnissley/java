package com.dnissley.ctci.chapter3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayQueueTest {
  @Test
  public void isEmptyReturnsCorrectValue() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>();
    assertTrue(q.isEmpty());
    q.add("a");
    assertFalse(q.isEmpty());
    q.add("b");
    assertFalse(q.isEmpty());
    q.add("c");
    assertFalse(q.isEmpty());
    q.remove();
    assertFalse(q.isEmpty());
    q.remove();
    assertFalse(q.isEmpty());
    q.remove();
    assertTrue(q.isEmpty());
    q.add("g");
    assertFalse(q.isEmpty());
  }

  @Test
  public void peekReturnsCorrectValue() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>();
    q.add("a");
    q.add("b");
    q.add("c");
    assertEquals("a", q.peek());
  }

  @Test(expected = Exception.class)
  public void peekOnEmptyQueueThrowsException() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>();
    q.peek();
  }

  @Test(expected = Exception.class)
  public void removeOnEmptyQueueThrowsException() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>();
    q.remove();
  }
}
