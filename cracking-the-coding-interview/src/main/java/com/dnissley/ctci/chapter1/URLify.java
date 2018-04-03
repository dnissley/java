package com.dnissley.ctci.chapter1;

/* Question 1.3

Write a method to replace all spaces in a string with '%20'. You may assume that
the string has sufficient space at the end to hold the additional characters, and
that you are given the "true" length of the string. (Note: If implementing in Java,
please use a character array so that you can perform this operation in place.)

*/

public class URLify {
  static final char SPACE = ' ';

  public static void replaceSpacesInPlace(char[] str, int length) {
    // A brute force solution would be to scan through the string and replace
    // each space we come to, shifting all of the elements coming after the 
    // space 2 places to the right. In the worst case of a string of all
    // spaces that would take time on the order of O(n^2), with a space
    // complexity of O(1) since we don't use any addititional space other
    // than the array itself and a fixed number of counters.

    // A better solution would be to scan through the array and create a
    // parallel array of the number of places each character in the array
    // would need to be shifted by, without actually doing the shifting.
    // Then go back through the array and do the shifting once. That would
    // take time on the order of O(n), even in the worst case. The trade off
    // is that this would take O(n) space.

    int[] shifts = new int[length];
    int cumulativeShifts = 0;
    
    for (int i = 0; i < length; i++) {
      shifts[i] = cumulativeShifts;
      if (str[i] == SPACE) {
        cumulativeShifts += 2;
      }
    }

    for (int i = length - 1; i >= 0; i--) {
      if (str[i] == SPACE) {
        str[i+shifts[i]] = '%';
        str[i+shifts[i]+1] = '2';
        str[i+shifts[i]+2] = '0';
      }
      else {
        str[i+shifts[i]] = str[i];
      }
    }
  }
}

