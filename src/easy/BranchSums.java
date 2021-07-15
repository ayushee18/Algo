package easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Write a function that takes in a Binary Tree and returns a list of its branch
 sums ordered from leftmost branch sum to rightmost branch sum.

 A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
 branch is a path of nodes in a tree that starts at the root node and ends at
 any leaf node.

 Each Binary Tree node has an integer value, a left child node, and a right child node. Children
 nodes can either be Binary Tree nodes themselves or None/Null.

 Sample Input  =     1
                  /     \
                2       3
              /   \    /  \
            4     5  6    7
          /   \  /
          8    9 10

 Sample Output: [15, 16, 18, 10, 11]
 // 15 == 1 + 2 + 4 + 8
 // 16 == 1 + 2 + 4 + 9
 // 18 == 1 + 2 + 5 + 10
 // 10 == 1 + 3 + 6
 // 11 == 1 + 3 + 7
 */
public class BranchSums {
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static void branchSumsUtil(BinaryTree root, List<Integer> result, int sum) {
    // Write your code here.
    if(root == null) {
      return;
    }
    int currSum = sum + root.value;
    if(root.left == null && root.right == null) {
      result.add(currSum);
      sum = 0;
      //return; //This will work too.
    }
    branchSumsUtil(root.left, result, currSum);
    branchSumsUtil(root.right, result, currSum);
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
    List<Integer> result = new ArrayList<>();
    return result;
  }

  public static void main(String[] args) {
    BinaryTree root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.right = new BinaryTree(3);
    root.left.left = new BinaryTree(4);
    root.left.right = new BinaryTree(5);
    root.left.left.left = new BinaryTree(8);
    root.left.left.right = new BinaryTree(9);
    root.left.right.left = new BinaryTree(10);
    root.right.left = new BinaryTree(6);
    root.right.right = new BinaryTree(7);

    List<Integer> result = branchSums(root);
    for (Integer a : result) {
      System.out.print(a + " ");
    }
  }
}
