package medium;

import java.util.Arrays;

/**
 *
 Given an array of positive integers representing coin denominations and a
 single non-negative integer n representing a target amount of
 money, write a function that returns the smallest number of coins needed to
 make change for (to sum up to) that target amount using the given coin
 denominations.

 Note that you have access to an unlimited amount of coins. In other words, if
 the denominations are [1, 5, 10], you have access to an unlimited
 amount of 1s, 5s and 10s.

 If it's impossible to make change for the target amount, return -1.

 Sample Input
 n = 7
 denoms = [1, 5, 10]

 Sample Output
 3 // 2x1 + 1x5
 */
public class MinNumberOfCoinsForChange {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
    int [] minCoins = new int [n + 1];
    // Filling array with max val as initially default value zero will be less than minCoins[amount - denom]
    Arrays.fill(minCoins, Integer.MAX_VALUE);
    minCoins[0] = 0;
    int toCompare = 0;

    for(int denom: denoms) {
      for (int amount = 1; amount < n + 1; amount++) {
        if (amount >= denom) {
          if (minCoins[amount - denom] == Integer.MAX_VALUE) {
            // doing this directly using formula: Math.min(minCoins[amount], 1 + minCoins[amount - denom]) in later
            // step will cause problem as 1 + Integer.MAX_VALUE leads to negative result.
            toCompare = minCoins[amount - denom];
          } else {
            toCompare = 1 + minCoins[amount - denom];
          }
          minCoins[amount] = Math.min(minCoins[amount], toCompare);
        }
      }
    }
    return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
  }

  public static void main(String[] args) {
    int [] array = {3, 4, 5};
    System.out.println(minNumberOfCoinsForChange(9, array));
  }
}
