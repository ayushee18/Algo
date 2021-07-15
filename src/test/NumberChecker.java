package test;

import java.util.Arrays;

public class NumberChecker {
  static String findQualifiedNumbers(int[] numberArray) {
    Arrays.sort(numberArray);
    char one = '1', two = '2', three = '3';
    for(int i = 0; i < numberArray.length; i++) {
      String str = "" + numberArray[i];
      if(str.contains(String.valueOf(one))) {

      }
    }
    return null;
  }

}
