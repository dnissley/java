package com.dnissley.ctci.chapter1;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UniqueCharactersTest {
  @Test
  public void emptyStringShouldPassUniquenessTest() {
    assertTrue(UniqueCharacters.testString(""));
  }

  @Test
  public void singleCharacterStringShouldPassUniquenessTest() {
    assertTrue(UniqueCharacters.testString("a"));
  }

  @Test
  public void shortStringWithUniqueCharactersShouldPassUniquenessTest() {
    String testStr = "odjsbc";
    assertTrue(UniqueCharacters.testString(testStr));
  }

  @Test
  public void longStringWithUniqueCharactersShouldPassUniquenessTest() {
    String testStr = "abcdefghijklmnopqrstuvwxyz1234567890";
    assertTrue(UniqueCharacters.testString(testStr));
  }

  @Test
  public void shortStringWithRepeatingCharacterShouldFailUniquenessTest() {
    String testStr = "odjsjbc";
    assertFalse(UniqueCharacters.testString(testStr));
  }

  @Test
  public void longStringWithRepeatingCharacterShouldFailUniquenessTest() {
    String testStr = "abcdefghijklmnopqrstuvwxyz12345678901";
    assertFalse(UniqueCharacters.testString(testStr));
  }

  @Test
  public void stringWithMultipleRepeatingCharactersShouldFailUniquenessTest() {
    String testStr = "abcbcbcbcbcd";
    assertFalse(UniqueCharacters.testString(testStr));
  }
}

