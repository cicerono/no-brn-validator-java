package no.cicero.common;

public class NoBrnValidator {

  public static boolean isValid(String brn) {
    if (brn == null
      || brn.length() != 9
      || !brn.matches("^[0-9]+$")) {
      return false;
    }

    int checksum = calculateChecksum(brn.substring(0, 8));

    if (checksum == -1
      || checksum != Character.getNumericValue(brn.charAt(8))) {
      return false;
    }

    return true;
  }

  public static int calculateChecksum(String brn) {
    if (brn == null
      || brn.length() != 8) {
      return -1;
    }

    int[] numbers = new int[brn.length()];
    for (int i = 0; i < brn.length(); i++) {
      numbers[i] = Character.getNumericValue(brn.charAt(i));
    }


    int checksum =
      11 - (
        ( 3 * numbers[0]
        + 2 * numbers[1]
        + 7 * numbers[2]
        + 6 * numbers[3]
        + 5 * numbers[4]
        + 4 * numbers[5]
        + 3 * numbers[6]
        + 2 * numbers[7]
        )
        % 11
      );

    if (checksum == 10) {
      return -1;
    }

    if (checksum == 11) {
      checksum = 0;
    }

    return checksum;
  }
}
