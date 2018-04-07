package com.dnissley.ctci.chapter3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayQueueTest {
  @Test
  public void firstAddsThenRemovesProduceCorrectValues() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>();
    q.add("a");
    assertEquals("a", q.peek());
    q.add("b");
    assertEquals("a", q.peek());
    q.add("c");
    assertEquals("a", q.peek());
    assertEquals("a", q.remove());
    assertEquals("b", q.remove());
    assertEquals("c", q.remove());
  }

  @Test
  public void mixOfAddsThenRemovesProduceCorrectValues() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>();
    q.add("-"); // -
    q.add("-"); // --
    assertEquals("-", q.remove()); // -
    assertEquals("-", q.remove()); // <empty>
    q.add("-"); // -
    q.add("h"); // -h
    q.add("e"); // -he
    assertEquals("-", q.remove()); // he
    q.add("l"); // hel
    assertEquals("h", q.remove()); // el
    q.add("l"); // ell
    q.add("o"); // ello
    assertEquals("e", q.remove()); // llo
    assertEquals("l", q.remove()); // lo
    assertEquals("l", q.remove()); // o
    q.add("!"); // o!
    assertEquals("o", q.remove()); // !
    assertEquals("!", q.remove()); // <empty>
  }

  @Test
  public void bigQueueWorksAsExpected() throws Exception {
    ArrayQueue<String> q = new ArrayQueue<>(2);
    for (int i = 0; i < 100; i++) {
      q.add(Integer.toString(i));
      assertEquals("0", q.peek());
    }
    for (int i = 0; i < 100; i++) {
      assertEquals(Integer.toString(i), q.peek());
      assertEquals(Integer.toString(i), q.remove());
    }
  }

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
