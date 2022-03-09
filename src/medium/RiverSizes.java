package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 You're given a two-dimensional array (a matrix) of potentially unequal height
 and width containing only 0s and 1s. Each 0  represents land, and each 1 represents part of a
 river. A river consists of any number of 1s that are either
 horizontally or vertically adjacent (but not diagonally adjacent). The number
 of adjacent 1s forming a river determine its size.

 Note that a river can twist. In other words, it doesn't have to be a straight
 vertical line or a straight horizontal line; it can be L-shaped, for example.

 Write a function that returns an array of the sizes of all rivers represented
 in the input matrix. The sizes don't need to be in any particular order.

 Sample Input
 matrix = [
 [1, 0, 0, 1, 0],
 [1, 0, 1, 0, 0],
 [0, 0, 1, 0, 1],
 [1, 0, 1, 0, 1],
 [1, 0, 1, 1, 0],
 ]

 Sample Output
 [1, 2, 2, 2, 5]// The numbers could be ordered differently.
 // The numbers could be ordered differently.
 // [
 //   [1,  ,  , 1,  ],
 //   [1,  , 1,  ,  ],
 //   [ ,  , 1,  , 1],
 //   [1,  , 1,  , 1],
 //   [1,  , 1, 1,  ],
 // ]
 */
public class RiverSizes {
  public static List<Integer> riverSizes(int[][] matrix) {
    List<Integer> sizes = new ArrayList<>();
    boolean[][] visited = new boolean [matrix.length][matrix[0].length];

    for(int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (visited[i][j]) {
          continue;
        }
        traverseNodes(matrix, sizes, visited, i, j);
      }
    }
    return sizes;
  }

  public static void traverseNodes(int[][] matrix, List<Integer> sizes, boolean[][] visited, int i, int j) {
    int currentRiverSize = 0;
    Stack<int[]> nodeToTraverse = new Stack<>();
    nodeToTraverse.push(new int[] {i, j});

    while(!nodeToTraverse.isEmpty()) {
      int[] currentNode = nodeToTraverse.pop();
      i = currentNode[0];
      j = currentNode[1];

      if(visited[i][j]) {
        continue;
      }
      visited[i][j] = true;
      if (matrix[i][j] == 0) {
        continue;
      }
      currentRiverSize++;
      findNodesToTraverse(nodeToTraverse, visited, i, j);
    }

    if(currentRiverSize > 0) {
      sizes.add(currentRiverSize);
    }
  }

  public static void findNodesToTraverse(Stack<int[]> nodeToTraverse, boolean[][] visited, int i, int j) {
    if (i > 0 && !visited[i-1][j]) {
      nodeToTraverse.add(new int[] {i-1, j});
    }
    if (i < visited.length - 1 && !visited[i+1][j]) {
      nodeToTraverse.add(new int[] {i+1, j});
    }
    if (j > 0 && !visited[i][j-1]) {
      nodeToTraverse.add(new int[] {i, j-1});
    }
    if (j < visited[0].length - 1 && !visited[i][j+1]) {
      nodeToTraverse.add(new int[] {i, j+1});
    }
  }
}
