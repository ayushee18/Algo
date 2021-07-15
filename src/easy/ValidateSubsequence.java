package easy;

import java.util.Arrays;
import java.util.List;

/**
 *
 Given two non-empty arrays of integers, write a function that determines
 whether the second array is a subsequence of the first one.

 A subsequence of an array is a set of numbers that aren't necessarily adjacent
 in the array but that are in the same order as they appear in the array. For
 instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4] , and so do the numbers [2, 4].
 Note that a single number in an array and the array itself are both valid
 subsequences of the array.

 Sample Input
 array = [5, 1, 22, 25, 6, -1, 8, 10]
 sequence  = [1, 6, -1, 10]

 Sample Output
 true
 */
public class ValidateSubsequence {

  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int arrIndex = 0, seqIndex = 0;
    while (arrIndex < array.size() && seqIndex < sequence.size()) {
      if(array.get(arrIndex) == sequence.get(seqIndex)) {
        seqIndex++;
      }
      arrIndex++;
    }
    if (seqIndex == sequence.size()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Integer [] array = {5, 1, 22, 25, 6, -1, 8, 10};
    Integer [] sequence = {1, 6, -1, -1};
    System.out.println(isValidSubsequence(Arrays.asList(array), Arrays.asList(sequence)));
  }

}
