package no.cicero.common;

import junit.framework.TestCase;

public class NoBrnValidatorTest extends TestCase {

  public NoBrnValidatorTest(String name) {
    super(name);
  }

  public void testIsValid() {
    assertFalse("should return false for null", NoBrnValidator.isValid(null));

    assertFalse("should return false for strings less than 9 characters", NoBrnValidator.isValid("97476067"));

    assertFalse("should return false for strings more than 9 characters", NoBrnValidator.isValid("9747606730"));

    assertFalse("should return false for strings containing more than just digits", NoBrnValidator.isValid("97476a673"));

    assertFalse("should return false for a number where the checksum is wrong", NoBrnValidator.isValid("974760674"));

    assertTrue("should return true for a correct number", NoBrnValidator.isValid("974760673"));
  }

  public void testCalculateChecksum() {
    assertEquals("should return -1 for null", -1, NoBrnValidator.calculateChecksum(null));

    assertEquals("should return -1 for strings less than 8 characters", -1, NoBrnValidator.calculateChecksum("1102159"));

    assertEquals("should return -1 for strings more than 8 characters", -1, NoBrnValidator.calculateChecksum("110215999"));

    assertEquals("should return 0 for 99311384", 0, NoBrnValidator.calculateChecksum("99311384"));

    assertEquals("should return 1 for 96735840", 1, NoBrnValidator.calculateChecksum("96735840"));

    assertEquals("should return 2 for 98763173", 2, NoBrnValidator.calculateChecksum("98763173"));

    assertEquals("should return 3 for 91385017", 3, NoBrnValidator.calculateChecksum("91385017"));

    assertEquals("should return 4 for 99922187", 4, NoBrnValidator.calculateChecksum("99922187"));

    assertEquals("should return 5 for 91374288", 5, NoBrnValidator.calculateChecksum("91374288"));

    assertEquals("should return 6 for 97586509", 6, NoBrnValidator.calculateChecksum("97586509"));

    assertEquals("should return 7 for 99356845", 7, NoBrnValidator.calculateChecksum("99356845"));

    assertEquals("should return 8 for 96094997", 8, NoBrnValidator.calculateChecksum("96094997"));

    assertEquals("should return 9 for 99674026", 9, NoBrnValidator.calculateChecksum("99674026"));

    // Using thse formula would yield 10, but 10 is not allowed as a checksum.
    assertEquals("should return -1 for 11100000", -1, NoBrnValidator.calculateChecksum("11100000"));
  }
}
