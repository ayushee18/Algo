package medium;

/**
 *
 You're given two positive integers representing the width and height of a
 grid-shaped, rectangular graph. Write a function that returns the number of
 ways to reach the bottom right corner of the graph when starting at the top
 left corner. Each move you take must either go down or right. In other words,
 you can never move up or left in the graph.

 For example, given the graph illustrated below, with width = 2 and height = 3, there are three ways to
 reach the bottom right corner when starting at the top left corner:
  _ _
 |_|_|
 |_|_|
 |_|_|

 1) Down, Down, Right
 2) Right, Down, Down
 3) Down, Right, Down

 Note: you may assume that<span>width * height &gt;= 2</span>. In other words,
 the graph will never be a 1x1 grid.

 Sample Input
 width = 4
 height = 3

 Sample Output
 10
 */
public class NumberOfWaysToTraverseGraph {
  // better solution O(n*m) time complexity and O(n*m) space complexity.
  // Mostly expected solution.
  public int numberOfWaysToTraverseGraphDP(int width, int height) {
    int[][] result = new int [width][height];

    for (int i = 1; i < width; i++) {
      result[i][0] = 1;
    }

    for (int i = 1; i < height; i++) {
      result[0][i] = 1;
    }

    for (int i = 1; i < width; i++) {
      for (int j = 1; j < height; j++) {
        result[i][j] = result[i][j - 1] + result[i - 1][j];
      }
    }
    return result[width - 1][height - 1];
  }

  // Worst solution with O(2^(n+m)) time | O(n+m) space where n is width and m is height.
  // O(2^(n+m)) time because for each square there are 2 recursive call and there are n+m calls
  public int numberOfWaysToTraverseGraphRecursion(int width, int height) {
   if (width == 1 || height == 1) {
     return 1;
   }
   return this.numberOfWaysToTraverseGraphRecursion(width - 1, height) +
       this.numberOfWaysToTraverseGraphRecursion(width, height - 1);
  }

  // Best solution but not expected as uses mathematical permutation formula: (N+M)! / N! * M!
  // as if w = 4 and h = 3 one way : {R, R, D, D, D} so all permutation of this.
  // N = w - 1, M = h - 1;
  public int numberOfWaysToTraverseGraphPermutation(int width, int height) {
   int N = width - 1;
   int M = height - 1;

   int numerator = this.factorial(N + M);
   int denominator = this.factorial(N) * this.factorial(M);

   return numerator/denominator;
  }

  public int factorial(int value) {
    int result = 1;

    for (int i = value; i >= 1; i--) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new NumberOfWaysToTraverseGraph().numberOfWaysToTraverseGraphPermutation(4, 3));
  }
}
