package com.dnissley.ctci.chapter2;

/* Question 2.3

Delete Middle Node: Implement an algorithm to delete a node in the middle
(i.e. any node but the first and last node, not necessarily the exact 
middle) of a singly linked list, given only acess to that node.

*/

public class DeleteMiddleNode {
  public static <T> void delete(Node<T> nodeToDelete) throws Exception {
    // Since we don't have access to the node previous to the node we are
    // deleting, we will need to accomplish this operation through copying
    // each node's value to the previous node and then deleting the last
    // node.

    Node<T> previous = null;
    Node<T> current = nodeToDelete;
    Node<T> next = current.getNext();

    while (next != null) {
      // Copy the next node's value to the current node.
      current.setData(next.getData());

      // Proceed to the next node.
      previous = current;
      current = next;
      next = current.getNext();
    }

    if (previous != null) {
      // We have reached the end of the list so need to delete the current node.
      previous.setNext(null);
    }
    else /* previous == null */ {
      // It appears we are trying to delete the last node of a list, which
      // isn't possible given access only to the node to delete.
      throw new Exception("No, we can't do that.");
    }
  }
}

/* Analysis

This solution has a time complexity of O(n) and a space complexity of O(1).

The time complexity is linear since we run a loop over each node in the list.

The space complexity is constant since we don't use any additional space beyond
the variables used to keep track of the previous/current/next nodes.

*/

