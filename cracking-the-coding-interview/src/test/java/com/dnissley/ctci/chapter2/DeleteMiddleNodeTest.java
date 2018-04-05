package com.dnissley.ctci.chapter2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DeleteMiddleNodeTest {

  @Test
  public void deletePerformsAsExpected() throws Exception {
    Node<String> actual = LinkedList.create("a", "b", "c", "d");
    Node<String> cNode = actual.getNext().getNext();
    DeleteMiddleNode.delete(cNode);
    Node<String> expected = LinkedList.create("a", "b", "d");
    assertTrue(LinkedList.areEqual(actual, expected));
  }

  @Test
  public void multipleDeletesPerformAsExpected() throws Exception {
    Node<String> actual = LinkedList.create("a", "b", "c", "d", "e", "f");
    Node<String> dNode = actual.getNext().getNext().getNext();
    DeleteMiddleNode.delete(dNode);
    Node<String> cNode = actual.getNext().getNext();
    DeleteMiddleNode.delete(cNode);
    Node<String> eNode = actual.getNext().getNext();
    DeleteMiddleNode.delete(eNode);
    Node<String> bNode = actual.getNext();
    DeleteMiddleNode.delete(bNode);
    Node<String> expected = LinkedList.create("a", "f");
    assertTrue(LinkedList.areEqual(actual, expected));
  }

  @Test
  public void deleteFirstNodePerformsAsExpected() throws Exception {
    Node<String> actual = LinkedList.create("a", "b", "c");
    DeleteMiddleNode.delete(actual);
    Node<String> expected = LinkedList.create("b", "c");
    assertTrue(LinkedList.areEqual(actual, expected));
  }

  @Test(expected = Exception.class)
  public void cantDeleteLastNode() throws Exception {
    Node<String> list = LinkedList.create("a", "b", "c");
    Node<String> cNode = list.getNext().getNext();
    DeleteMiddleNode.delete(cNode);
  }
}

