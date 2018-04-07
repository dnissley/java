package com.dnissley.ctci.chapter3;

public class ArrayQueue<T> {
  public static final int DEFAULT_CAPACITY = 10;
  T[] items;
  int head;
  int size;

  public ArrayQueue() {
    initialize(DEFAULT_CAPACITY);
  }

  public ArrayQueue(int initialCapacity) {
    initialize(initialCapacity);
  }

  public void add(T item) {
    if (size == items.length) {
      growCapacity();
    }

    items[tail()] = item;
    size++;
  }

  public T remove() throws Exception {
    T peeked = peek();
    
    head++;
    if (head >= items.length) {
      head %= items.length;
    }
    size--;

    return peeked;
  }

  public T peek() throws Exception {
    if (size <= 0) {
      throw new Exception();
    }
    else {
      return items[head];
    }
  }

  public boolean isEmpty() {
    return size <= 0;
  }

  private int tail() {
    return (head + size) % items.length;
  }

  private void growCapacity() {
    T[] oldItems = items;
    items = (T[]) new Object[oldItems.length * 2];
    int copyFrom = head;
    for (int copyTo = 0; copyTo < oldItems.length; copyTo++) {
      items[copyTo] = oldItems[copyFrom];
      copyFrom++;
      if (copyFrom >= oldItems.length) {
        copyFrom = copyFrom % oldItems.length;
      }
    }
    head = 0;
  }

  private void initialize(int capacity) {
    items = (T[]) new Object[capacity];
    head = 0;
    size = 0;
  }
}
