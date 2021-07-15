package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Write a function that takes in an n x m two-dimensional array (that can be
 square-shaped when n == m) and returns a one-dimensional array of all the
 array's elements in spiral order.

 Spiral order starts at the top left corner of the two-dimensional array, goes
 to the right, and proceeds in a spiral pattern all the way until every element
 has been visited.

 Sample Input
 array = [
      [1,   2,  3, 4],
      [12, 13, 14, 5],
      [11, 16, 15, 6],
      [10,  9,  8, 7],
    ]

 Sample Output
 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
 */
public class SpiralTraverse {
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
    List<Integer> result = new ArrayList<>();
    int dir = 0;
    int topRow = 0, bottomRow = array.length - 1, colLeft = 0, colRight = array[0].length - 1;

    while(topRow <= bottomRow && colLeft <= colRight) {
      if(dir == 0) {
        for(int i = colLeft; i <= colRight; i++) {
          result.add(array[topRow][i]);
        }
        dir = 1; topRow++;
      } else if(dir == 1) {
        for(int i = topRow; i <= bottomRow; i++) {
          result.add(array[i][colRight]);
        }
        dir = 2; colRight--;
      } else if(dir == 2) {
        for(int i = colRight; i >= colLeft; i--) {
          result.add(array[bottomRow][i]);
        }
        dir = 3; bottomRow--;
      } else if(dir == 3) {
        for(int i = bottomRow; i >= topRow; i--) {
          result.add(array[i][colLeft]);
        }
        dir=0; colLeft++;
      }
    }
    return result;
  }
}
