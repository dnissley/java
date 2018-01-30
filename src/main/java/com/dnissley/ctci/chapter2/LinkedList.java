package com.dnissley.ctci.chapter2;

public class LinkedList {
  public static int length(Node<?> list) {
    if (list == null) {
      return 0;
    }

    int len = 1;

    while (list.getNext() != null) {
      len++;
      list = list.getNext();
    }
    
    return len;
  }

  public static <T> Node<T> create(T ... xs) {
    if (xs == null || xs.length == 0) {
      return null;
    }

    Node<T> first = new Node<T>(xs[0]);
    Node<T> prev = first;

    for (int i = 1; i < xs.length; i++) {
      Node<T> next = new Node<T>(xs[i]);
      prev.setNext(next);
      prev = next;
    }

    return first;
  }

  public static <T> boolean areEqual(Node<T> list1, Node<T> list2) {
    if (list1 == null && list2 == null) {
      return true;
    } else if (list1 == null || list2 == null) {
      return false;
    }

    if (LinkedList.length(list1) != LinkedList.length(list2)) {
      return false;
    }

    do {
      if (!list1.getData().equals(list2.getData())) {
        return false;
      }
      list1 = list1.getNext();
      list2 = list2.getNext();
    } while (list1 != null);

    return true;
  }

  // get
  // append
  // remove
}

