package com.dnissley.ctci.chapter1;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PracticeArrayListTest {
  @Test
  public void canAddItemsToTheList() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    l.add("zero");
    assertEquals(l.get(0), "zero");
    l.add("one");
    assertEquals(l.get(1), "one");
    l.add("two");
    assertEquals(l.get(0), "zero");
    assertEquals(l.get(1), "one");
    assertEquals(l.get(2), "two");
  }

  @Test
  public void canRemoveItemsFromTheList() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    l.add("zero");
    assertEquals(l.remove(0), "zero");
    l.add("zero");
    l.add("one");
    l.add("two");
    l.add("three");
    assertEquals(l.remove(3), "three");
    assertEquals(l.remove(1), "one");
    assertEquals(l.remove(0), "zero");
    assertEquals(l.remove(0), "two");
  }

  @Test
  public void canClearList() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    assertEquals(l.length(), 0);
    l.add("zero");
    l.add("one");
    l.add("two");
    assertEquals(l.length(), 3);
    l.clear();
    assertEquals(l.length(), 0);
  }

  @Test
  public void lengthIsAccurate() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    assertEquals(l.length(), 0);
    l.add("zero");
    assertEquals(l.length(), 1);
    l.add("one");
    assertEquals(l.length(), 2);
    l.add("two");
    assertEquals(l.length(), 3);
    l.remove(0);
    assertEquals(l.length(), 2);
    l.remove(0);
    assertEquals(l.length(), 1);
    l.remove(0);
    assertEquals(l.length(), 0);
  }

  @Test
  public void canAddBeyondInitialCapacity() {
    PracticeArrayList<String> l = new PracticeArrayList<String>(4);
    for (int i = 0; i < 100; i++) {
      l.add(Integer.toString(i));
    }
    assertEquals(l.get(0), "0");
    assertEquals(l.get(50), "50");
    assertEquals(l.get(99), "99");
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroInitialCapacityThrowsException() {
    PracticeArrayList<String> l = new PracticeArrayList<String>(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeInitialCapacityThrowsException() {
    PracticeArrayList<String> l = new PracticeArrayList<String>(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void gettingTooBigIndexThrowsException() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    l.add("zero");
    l.get(1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void gettingNegativeIndexThrowsException() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    l.add("zero");
    l.get(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void removingTooBigIndexThrowsException() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    l.add("zero");
    l.add("one");
    l.add("two");
    l.get(3);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void removingNegativeIndexThrowsException() {
    PracticeArrayList<String> l = new PracticeArrayList<String>();
    l.get(-1);
  }
}

