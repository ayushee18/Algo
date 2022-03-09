package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 Write a function that takes in a non-empty array of distinct integers and an
 integer representing a target sum. The function should find all triplets in
 the array that sum up to the target sum and return a two-dimensional array of
 all these triplets. The numbers in each triplet should be ordered in ascending
 order, and the triplets themselves should be ordered in ascending order with
 respect to the numbers they hold.

 If no three numbers sum up to the target sum, the function should return an
 empty array.

 Sample Input:
 array = [12, 3, 1, 2, -6, 5, -8, 6]
 targetSum = 0

 Sample Output: [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
 */
public class ThreeNumberSum {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
    Arrays.sort(array);
    List<Integer[]> result = new ArrayList<>();
    for(int i = 0; i < array.length; i++) {
      int k = i + 1;
      int l = array.length - 1;
      while(k < l) {
        Integer sum = array[i] + array[k] + array[l];
        if(sum == targetSum) {
          result.add(new Integer[] {array[i], array[k], array[l]});
          k++; l--;
        } else if (sum < targetSum) {
          k++;
        } else {
          l--;
        }
      }
    }
    return result;
  }
}
