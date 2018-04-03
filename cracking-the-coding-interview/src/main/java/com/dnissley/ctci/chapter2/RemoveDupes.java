package com.dnissley.ctci.chapter2;

import java.util.HashSet;

/* Question 2.1

Write code to remove duplicates from an unsorted linked list.

*/

public class RemoveDupes {
  public static <T> void removeDupes(Node<T> list) {
    if (list == null) {
      return;
    }

    HashSet<T> set = new HashSet<T>();
    set.add(list.getData());
    Node<T> prev = list;
    Node<T> curr = list.getNext();

    while (curr != null) {
      T currData = curr.getData();
      if (set.contains(currData)) {
        Node<T> next = curr.getNext();
        prev.setNext(next);
        curr = next;
      }
      else {
        set.add(currData);
        prev = curr;
        curr = curr.getNext();
      }
    }
  }
}

/* Analysis

Time Complexity: O(n) since we make one pass over the data in the list. The
  set operations should be O(1) so they do not add to the time complexity.

Space Complexity: O(n) in the worst case when the list contains all unique
  elements and we add n elements to the set.

*/
