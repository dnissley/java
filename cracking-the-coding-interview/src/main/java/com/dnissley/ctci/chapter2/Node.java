package com.dnissley.ctci.chapter2;

public class Node<T> {
  T data;
  Node<T> next = null;

  public Node(T data) {
    setData(data);
  }

  public void setData(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public Node<T> getNext() {
    return next;
  }
}

