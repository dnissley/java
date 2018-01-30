package com.dnissley.ctci.chapter2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {

  @Test
  public void lengthReturnsCorrectNumber() {
    Node<String> list1 = LinkedList.create("a", "b", "c");
    Node<String> list2 = null;
    Node<String> list3 = new Node<String>("bla");
    assertEquals(LinkedList.length(list1), 3);
    assertEquals(LinkedList.length(list2), 0);
    assertEquals(LinkedList.length(list3), 1);
  }

  @Test
  public void createMakesALinkedList() {
    Node<String> list = LinkedList.create("a", "b", "c");
    Node<String> expected = new Node<String>("a");
    expected.setNext(new Node<String>("b"));
    expected.getNext().setNext(new Node<String>("c"));
    assertTrue(LinkedList.areEqual(list, expected));
  }

  @Test
  public void listsOfDifferentLengthsArentEqual() {
    Node<String> list1 = LinkedList.create("a", "b", "c");
    Node<String> list2 = LinkedList.create("a", "b", "c", "d");
    assertFalse(LinkedList.areEqual(list1, list2));
  }

  @Test
  public void listsOfTheSameLengthArentNecessarilyEqual() {
    Node<String> list1 = LinkedList.create("a", "b", "c");
    Node<String> list2 = LinkedList.create("a", "b", "d");
    assertFalse(LinkedList.areEqual(list1, list2));
  }

  @Test
  public void listsOfTheSameElementsAreEqual() {
    Node<String> list1 = LinkedList.create("a", "b", "c");
    Node<String> list2 = LinkedList.create("a", "b", "c");
    assertTrue(LinkedList.areEqual(list1, list2));
  }

  @Test
  public void nullListsAreEqual() {
    Node<String> list1 = null;
    Node<String> list2 = null;
    assertTrue(LinkedList.areEqual(list1, list2));
  }

  @Test
  public void nullListsArentEqualToNonNullLists() {
    Node<String> nullList = null;
    Node<String> nonNullList = new Node<String>("a");
    assertFalse(LinkedList.areEqual(nullList, nonNullList));
  }
}

