package medium;

/**
 *
 Write a function that takes in an array of positive integers and returns the
 maximum sum of non-adjacent elements in the array.

 If the input array is empty, the function should return 0.

 Sample Input:
 array = [75, 105, 120, 75, 90, 135]

 Sample Output
 330 // 75 + 120 + 135
 */
public class MaxSubsetSumNoAdjacent {

  //formula = Math.max(array[i - 1], array[i - 2] + array[i]
  public static int maxSubsetSumNoAdjacent(int[] array) {

    if(array.length == 0) {
      return 0;
    }

    if(array.length == 1) {
      return array[0];
    }

    if(array.length == 2) {
      return Math.max(array[0], array[1]);
    }

    int maxTwoStepsBack = array[0];
    int maxOneStepBack = Math.max(array[0], array[1]);
    int currMax = 0;

    for (int i = 2; i < array.length; i++) {
      //temp[i] = Math.max(temp[i-1], temp[i-2] + array[i]);
      currMax = Math.max(maxOneStepBack, maxTwoStepsBack + array[i]);
      maxTwoStepsBack = maxOneStepBack;
      maxOneStepBack = currMax;
    }

    return currMax;
  }
}
