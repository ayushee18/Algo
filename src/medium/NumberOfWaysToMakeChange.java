package medium;

import java.util.Arrays;

/**
 *
 Given an array of distinct positive integers representing coin denominations and a
 single non-negative integer n representing a target amount of
 money, write a function that returns the number of ways to make change for
 that target amount using the given coin denominations.

 Note that an unlimited amount of coins is at your disposal.

 Sample Input
 n = 6
 denoms = [1, 5]

 Sample Output
 2 // 1x1 + 1x5 and 6x1
 */
public class NumberOfWaysToMakeChange {
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    int[] ways = new int[n + 1];
    ways[0] = 1;
    for (int denom : denoms) {
      for (int amount = 0; amount < n + 1; amount++) {
        if (denom <= amount) {
          ways[amount] += ways[amount - denom];
        }
      }
    }
    System.out.println(Arrays.binarySearch(denoms, 1));
    return ways[n];
  }

  public static void main(String[] args) {
    //System.out.println(numberOfWaysToMakeChange(842, 91));
  }
}
