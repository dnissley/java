package com.dnissley.ctci.chapter1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SortingAlgorithmsTest {
  @Test
  public void quickSortWorksOnEmptyArray() {
    int[] actual = new int[0];
    SortingAlgorithms.quickSort(actual);
    int[] expected = new int[0];
    assertArrayEquals(expected, actual);
  }

  @Test
  public void quickSortWorksOnSingleValue() {
    int[] actual = new int[] { 456 };
    SortingAlgorithms.quickSort(actual);
    int[] expected = new int[] { 456 };
    assertArrayEquals(expected, actual);
  }

  @Test
  public void quickSortWorksOnTwoValuesOutOfOrder() {
    int[] actual = new int[] { 321, 123 };
    SortingAlgorithms.quickSort(actual);
    int[] expected = new int[] { 123, 321 };
    assertArrayEquals(expected, actual);
  }

  @Test
  public void quickSortWorksOnTwoValuesInOrder() {
    int[] actual = new int[] { 123, 321 };
    SortingAlgorithms.quickSort(actual);
    int[] expected = new int[] { 123, 321 };
    assertArrayEquals(expected, actual);
  }

  @Test
  public void quickSortWorksOnManyValues() {
    int[] actual = new int[] { 9, 5, 1, 3, 7, 6, 1, 5, 10, 10, 5, 8, 2, 4, 1, 10 };
    SortingAlgorithms.quickSort(actual);
    int[] expected = new int[] { 1, 1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10, 10, 10 };
    assertArrayEquals(expected, actual);
  }
}
