package com.dnissley.ctci.chapter2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthToLastTest {

  @Test
  public void getsAllKthToLastFromLongList() {
    Node<String> list = LinkedList.create("a", "b", "c", "d", "e");
    assertEquals(KthToLast.kthToLast(list, 5), "a");
    assertEquals(KthToLast.kthToLast(list, 4), "b");
    assertEquals(KthToLast.kthToLast(list, 3), "c");
    assertEquals(KthToLast.kthToLast(list, 2), "d");
    assertEquals(KthToLast.kthToLast(list, 1), "e");
  }

  @Test
  public void getsAllKthToLastFromShortList() {
    Node<String> list = new Node<String>("a");
    assertEquals(KthToLast.kthToLast(list, 1), "a");
  }
}
