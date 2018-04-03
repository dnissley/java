package com.dnissley.ctci.chapter1;

import java.util.Arrays;

/* Question 1.2

Given two strings, write a method to determine if one is a permutation of the other.

*/

public class CheckPermutation {
  public static boolean testStrings(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }

    char[] aChars = a.toCharArray();
    char[] bChars = b.toCharArray();

    Arrays.sort(aChars);
    Arrays.sort(bChars);

    for (int i = 0; i < aChars.length; i++) {
      if (aChars[i] != bChars[i]) {
        return false;
      }
    }

    return true;
  }
}

