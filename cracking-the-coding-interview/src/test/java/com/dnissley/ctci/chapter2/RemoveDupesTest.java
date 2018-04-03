package com.dnissley.ctci.chapter2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RemoveDupesTest {
  @Test
  public void removesDupesFromEnd() {
    Node<String> list = LinkedList.create("a", "b", "c", "b", "b");
    RemoveDupes.removeDupes(list);
    assertTrue(LinkedList.areEqual(list, LinkedList.create("a", "b", "c")));
  }

  @Test
  public void removesDupesFromMiddle() {
    Node<String> list = LinkedList.create("a", "b", "b", "b", "c");
    RemoveDupes.removeDupes(list);
    assertTrue(LinkedList.areEqual(list, LinkedList.create("a", "b", "c")));
  }

  @Test
  public void removesDupesFromBeginning() {
    Node<String> list = LinkedList.create("a", "a", "a", "b", "c");
    RemoveDupes.removeDupes(list);
    assertTrue(LinkedList.areEqual(list, LinkedList.create("a", "b", "c")));
  }

  @Test
  public void removesAllSortsOfDupes() {
    Node<String> list = LinkedList.create("a", "a", "b", "c", "b", "a", "c", "c", "d", "a", "b", "c", "d");
    RemoveDupes.removeDupes(list);
    assertTrue(LinkedList.areEqual(list, LinkedList.create("a", "b", "c", "d")));
  }

  @Test
  public void maintainsUniqueList() {
    Node<String> list = LinkedList.create("a", "b", "c", "d");
    RemoveDupes.removeDupes(list);
    assertTrue(LinkedList.areEqual(list, LinkedList.create("a", "b", "c", "d")));
  }
}
 
