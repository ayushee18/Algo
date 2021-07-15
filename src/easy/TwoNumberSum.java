package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 Write a function that takes in a non-empty array of distinct integers and an
 integer representing a target sum. If any two numbers in the input array sum
 up to the target sum, the function should return them in an array, in any
 order. If no two numbers sum up to the target sum, the function should return
 an empty array.

 Note that the target sum has to be obtained by summing two different integers
 in the array; you can't add a single integer to itself in order to obtain the
 target sum.

 You can assume that there will be at most one pair of numbers summing up to
 the target sum.

 Sample Input
 array = [3, 5, -4, 8, 11, 1, -1, 6]
 targetSum = 10
 sample Output = [-1, 11]
 */
public class TwoNumberSum {

  //O(n) time and O(n) space
  public static int[] twoNumberSum1(int[] array, int targetSum) {
    // Write your code here.
    Set<Integer> set = new HashSet<>();
    for (int element: array) {
      if(set.contains(targetSum - element)) {
        return new int [] {element, targetSum -element};
      } else {
        set.add(element);
      }
    }
    return new int[0];
  }

  //O(nlog(n)) time and O(1) space
  public static int[] twoNumberSum2(int[] array, int targetSum) {
    Arrays.sort(array);
    int low = 0, high = array.length - 1;
    while (low <= high) {
      int sum = array[low] + array[high];

      if (sum == targetSum) {
        return new int[] {array[low], array[high]};
      } else if (sum < targetSum) {
        low++;
      } else {
        high--;
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int [] array = {3, 5, -4, 8, 11, 1, -1, 6};
    int [] result = twoNumberSum1(array, 10);
    System.out.println(result[0] + " " + result[1]);

    result = twoNumberSum2(array, 10);
    System.out.println(result[0] + " " + result[1]);
  }
}