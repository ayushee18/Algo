package medium;

/**
 *
 Write a function that takes in an array of integers and returns a boolean
 representing whether the array is monotonic.

 An array is said to be monotonic if its elements, from left to right, are
 entirely non-increasing or entirely non-decreasing.

 Non-increasing elements aren't necessarily exclusively decreasing; they simply
 don't increase. Similarly, non-decreasing elements aren't necessarily
 exclusively increasing; they simply don't decrease.

 Note that empty arrays and arrays of one element are monotonic.

 Sample Input
 array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]

 Sample Output = true
 */
public class MonotonicArray {

  public static boolean isMonotonic(int[] array) {
    // Write your code here.
    if(array.length == 0 || array.length == 1) {
      return true;
    }
    boolean isIncreasing = false;
    boolean isDecreasing = false;

    if(array[0] < array[array.length - 1]) {
      isIncreasing = true;
    } else {
      isDecreasing = true;
    }

    for(int i = 0; i < array.length - 1; i++) {
      if(isIncreasing && array[i] > array[i+1]) {
        return false;
      } else if (isDecreasing && array[i] < array[i+1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    int [] array = {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
    System.out.println(isMonotonic(array));
  }

}
