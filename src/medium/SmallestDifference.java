package medium;

import java.util.Arrays;

/**
 *
 Write a function that takes in two non-empty arrays of integers, finds the
 pair of numbers (one from each array) whose absolute difference is closest to
 zero, and returns an array containing these two numbers, with the number from
 the first array in the first position.

 Note that the absolute difference of two integers is the distance between
 them on the real number line. For example, the absolute difference of -5 and 5
 is 10, and the absolute difference of -5 and -4 is 1.

 You can assume that there will only be one pair of numbers with the smallest
 difference.

 Sample Input:
 arrayOne = [-1, 5, 10, 20, 28, 3]
 arrayTwo = [26, 134, 135, 15, 17]

 Sample Output: [28, 26]
 */
public class SmallestDifference {

  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    int [] result = new int [2];
    int minDiff = Integer.MAX_VALUE;
    int index1 = 0, index2 = 0;

    while (index1 < arrayOne.length && index2 < arrayTwo.length) {
      int diff = Math.abs(arrayOne[index1] - arrayTwo[index2]);
      if(diff < minDiff) {
        minDiff = diff;
        result[0] = arrayOne[index1];
        result[1] = arrayTwo[index2];
      } else {
        if(arrayOne[index1] < arrayTwo[index2]) {
          index1++;
        } else {
          index2++;
        }
      }
    }
    return result;
  }

}
