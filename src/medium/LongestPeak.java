package medium;

/**
 *
 Write a function that takes in an array of integers and returns the length of
 the longest peak in the array.

 A peak is defined as adjacent integers in the array that are strictly
 increasing until they reach a tip (the highest value in the peak), at which
 point they become strictly decreasing. At least three integers are required to
 form a peak.

 For example, the integers 1, 4, 10, 12 form a peak, but the
 integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0. Similarly, the integers
 1, 2, 3 don't form a peak because there aren't any strictly decreasing integers after the 3.

 Sample Inout
 array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]

 Sample Output
 6 // 0, 10, 6, 5, -1, -3
 */
public class LongestPeak {
  /**
   *
   As you iterate through the array from left to right, whenever you find a tip of a peak,
   expand outwards from the tip until you no longer have a peak. Given what peaks look like and how many peaks can
   therefore fit in an array, realize that this process results in a linear-time algorithm.
   Make sure to keep track of the longest peak you find as you iterate through the array.
   */
  public static int longestPeak(int[] array) {
    // Write your code here.
    int i = 1;
    int longestPeakLen = 0;
    while (i < array.length - 1) {
      boolean isPeak = array[i - 1] < array[i] && array[i] > array[i+1];
      if(!isPeak) {
        i++;
        continue;
      }
      int leftIdx = i - 2;
      while(leftIdx >=0 && array[leftIdx + 1] > array[leftIdx]) {
        leftIdx--;
      }

      int rightIdx = i + 2;
      while (rightIdx < array.length && array[rightIdx - 1] > array[rightIdx]) {
        rightIdx++;
      }
      int currLen = rightIdx - leftIdx - 1;
      longestPeakLen = Math.max(longestPeakLen, currLen);
      i = rightIdx;
    }
    return longestPeakLen;
  }

  public static void main(String[] args) {
    int[] array= {5, 4, 3, 2, 1, 2, 10, 12};
    System.out.println(longestPeak(array));
  }
}
