package com.dnissley.ctci.chapter1;

public class SortingAlgorithms {
  public static void quickSort(int[] a) {
    quickSort(a, 0, a.length - 1);
  }

  private static void quickSort(int[] a, int p, int r) {
    if (r - p > 0) {
      int q = partition(a, p, r);
      quickSort(a, p, q - 1);
      quickSort(a, q + 1, r);
    }
  }

  private static int partition(int[] a, int p, int r) {
    int q = p, n = p;

    while (n < r) {
      if (a[n] < a[r]) {
        int tmp = a[q];
        a[q] = a[n];
        a[n] = tmp;
        q++;
      }
      n++;
    }

    int tmp = a[q];
    a[q] = a[r];
    a[r] = tmp;

    return q;
  }
}