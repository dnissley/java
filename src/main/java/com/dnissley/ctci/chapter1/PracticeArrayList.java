package com.dnissley.ctci.chapter1;

import java.util.Arrays;

public class PracticeArrayList<T> {
  private static final int DEFAULT_CAPACITY = 100;
  private T[] items;
  private int initialCapacity = DEFAULT_CAPACITY;
  private int size = 0;

  public PracticeArrayList() {
    initializeItems();
  }

  public PracticeArrayList(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Invalid starting capacity");
    }

    this.initialCapacity = initialCapacity;
    initializeItems();
  }

  public int length() {
    return size;
  }

  public void add(T item) {
    ensureCapacity(size + 1);
    items[size] = item;
    size++;
  }

  public T get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    return items[index];
  }

  public T remove(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    T item = items[index];

    for (int i = index + 1; i < size; i++) {
      items[i - 1] = items[i];
    }

    size--;
    
    return item;
  }

  public void clear() {
    initializeItems();
    size = 0;
  }

  private void ensureCapacity(int newSize) {
    if (items.length >= newSize) {
      return;
    }

    int newCapacity = items.length;
    while (newCapacity < newSize) {
      newCapacity *= 2;
    }
    
    items = Arrays.copyOf(items, newCapacity);
  }

  private void initializeItems() {
    items = (T[]) new Object[initialCapacity];
  }

}

