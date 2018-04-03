package com.dnissley.ctci.chapter1;

import java.util.Arrays;

/* Question 1.1

Implement an algorithm to determine if a string has all unique characters.

*/

public class UniqueCharacters {
  public static boolean testString(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == chars[i-1]) {
        return false;
      }
    }
    return true;
  }
}

/* Solution Notes

What's the runtime of this algorithm?

The runtime of String.toCharArray() is probably O(n). 

The runtime of Arrays.sort(char[]) is O(n*log(n)).

The runtime of the for loop is O(n).

So the runtime of the algorithm is O(n + n*log(n) + n) = O(n*log(n) + 2n) = O(n*log(n)) after dropping constants and lower order terms.

*/

