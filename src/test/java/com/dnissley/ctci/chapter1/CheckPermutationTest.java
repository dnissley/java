package com.dnissley.ctci.chapter1;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckPermutationTest {

  @Test
  public void differentlyLengthedStringsShouldFailPermutationTest() { 
    String testStr1 = "abc";
    String testStr2 = "abcd";
    assertFalse(CheckPermutation.testStrings(testStr1, testStr2));
  }

  @Test
  public void emptyStringsShouldPassPermutationTest() {
    assertTrue(CheckPermutation.testStrings("", ""));
  }

  @Test
  public void testingStringAgainstItselfShouldPassPermutationTest() {
    String testStr = "asdfasdfasdf";
    assertTrue(CheckPermutation.testStrings(testStr, testStr));
  }

  @Test
  public void matchingStringsShouldPassPermutationTest() {
    String testStr1 = "hello";
    String testStr2 = "hello";
    assertTrue(CheckPermutation.testStrings(testStr1, testStr2));
  }

  @Test
  public void permutedStringsShouldPassPermutationTest() {
    String testStr = "abc";
    String[] permutations = new String[] { "abc", "acb", "bac", "bca", "cab", "cba" };
    for (String p : permutations) {
      assertTrue(CheckPermutation.testStrings(testStr, p));
    }
  }

  @Test
  public void relationDefinedByPermutationTestShouldBeSymmetric() {
    String testStr = "abc";
    String[] permutations = new String[] { "abc", "acb", "bac", "bca", "cab", "cba" };
    for (String p : permutations) {
      assertTrue(CheckPermutation.testStrings(p, testStr));
    }
  }

  @Test
  public void nonPermutationsShouldFailPermutationTest() {
    String testStr = "qqj";
    String[] nonPermutations = new String[] { "qqq", "jjj", "jjq", "qji", "xyz" };
    for (String np : nonPermutations) {
      assertFalse(CheckPermutation.testStrings(testStr, np));
    }
  }
}
