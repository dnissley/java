package com.dnissley.ctci.chapter2;

/* Question 2.2

Implement an algorithm to find the kth to last element of a singly linked list.

*/

public class KthToLast {
  public static <T> T kthToLast(Node<T> list, int k) {
    int length = LinkedList.length(list);
    int elementsFromTheEnd = k - 1; // 2nd to last means 1 from the end, 1st to last means the end itself, etc.
    int lastElement = length - 1;
    int target = lastElement - elementsFromTheEnd;
    
    for (int i = 0; i != target; i++) {
      list = list.getNext();
    }

    return list.getData();
  }
}
