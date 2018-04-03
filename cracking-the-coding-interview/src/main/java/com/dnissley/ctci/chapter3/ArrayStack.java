package com.dnissley.ctci.chapter3;

public class ArrayStack<T> {
  public static final int DEFAULT_CAPACITY = 10;
  T[] items;
  int head;
  int size;

  public ArrayStack() {
    initialize(DEFAULT_CAPACITY);
  }

  public ArrayStack(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException();
    }

    initialize(initialCapacity); 
  }

  public void push(T item) {
    if (size == items.length) {
      growCapacity();
    }

    int newHead = head - 1;

    if (head == 0) {
      newHead = items.length - 1;
    }

    items[newHead] = item;

    head = newHead;
    size++;
  }

  public T pop() throws Exception {
    T peeked = peek();

    size--;
    head++;

    if (head >= items.length) {
      head = head % items.length;
    }

    return peeked;
  }

  public T peek() throws Exception {
    if (size <= 0) {
      throw new Exception();
    }

    return items[head];
  }

  public boolean isEmpty() {
    return size <= 0;
  }

  private void growCapacity() {
    T[] newItems = (T[]) new Object[items.length * 2];
    for (int copyTo = 0; copyTo < size; copyTo++) {
      int copyFrom = copyTo + head;
      if (copyFrom >= items.length) {
        copyFrom = copyFrom % items.length;
      }
      newItems[copyTo] = items[copyFrom];
    }
    items = newItems;
    head = 0;
  }

  private void initialize(int initialCapacity) {
    items = (T[]) new Object[initialCapacity];
    size = 0;
    head = 0;
  }
}

