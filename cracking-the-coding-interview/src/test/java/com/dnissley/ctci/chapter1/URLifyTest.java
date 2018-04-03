package com.dnissley.ctci.chapter1;

import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class URLifyTest {

  public static void assertProperReplacement(String given, String expected) {
    int arrayLength = expected.length() + 123;
    char[] testStr = Arrays.copyOf(given.toCharArray(), arrayLength);
    char[] verificationStr = Arrays.copyOf(expected.toCharArray(), arrayLength);
    URLify.replaceSpacesInPlace(testStr, given.length());
    assertArrayEquals(testStr, verificationStr);
  }

  @Test
  public void noReplacementsOnStringWithoutSpaces() {
    assertProperReplacement("hello", "hello");
  }

  @Test
  public void replacesSingleSpace() {
    assertProperReplacement(" ", "%20");
  }

  @Test
  public void replacesMultipleSpaces() {
    assertProperReplacement("   ", "%20%20%20");
  }

  @Test
  public void replacesSingleSpaceAppendedToOtherCharacters() {
    assertProperReplacement("asdf ", "asdf%20");
  }

  @Test
  public void replacesSingleSpacePrependedToOtherCharacters() {
    assertProperReplacement(" asdf", "%20asdf");
  }

  @Test
  public void replacesMultipleSpacesMixedWithOtherCharacters() {
    assertProperReplacement("a s d f", "a%20s%20d%20f");
    assertProperReplacement(" kdk k", "%20kdk%20k");
    assertProperReplacement("ro fl ", "ro%20fl%20");
    assertProperReplacement(" asdf  qwerty ", "%20asdf%20%20qwerty%20");
  }
}

