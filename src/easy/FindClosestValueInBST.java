package easy;

/**
 *
 Write a function that takes in a Binary Search Tree (BST) and a target integer
 value and returns the closest value to that target value contained in the BST.

 You can assume that there will only be one closest value.

 Each BST node has an integer value, a left child node, and a right child node. A node is
 said to be a valid BST node if and only if it satisfies the BST
 property: its value is strictly greater than the values of every
 node to its left; its value is less than or equal to the values
 of every node to its right; and its children nodes are either valid
 nodes themselves or None/null.

 Sample Input
         10
        / \
       5   15
     / \  / \
     2 5  13 22
    /     \
   1      14
 target = 12

 Sample Output: 13
 */
public class FindClosestValueInBST {

  public static int findClosestValueInBstSol2(BST tree, int target) {
    int minDiff = Integer.MAX_VALUE;
    int diff = Math.abs(target - tree.value);
    int closest = tree.value;;
    while(tree != null) {
      diff = Math.abs(target - tree.value);
      if(minDiff > diff) {
        minDiff = diff;
        closest = tree.value;
      }
      if (target < tree.value) {
        tree = tree.left;
      }
      else if (target > tree.value) {
        tree = tree.right;
      }
      else {
        break;
      }
    }
    return closest;
  }

  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
    return findClosestValueInBstUtil(tree, target, tree.value);
  }

  public static int findClosestValueInBstUtil(BST tree, int target, int closest) {

    if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
      closest = tree.value;
    }

    if (tree.left != null && target < tree.value) {
      return findClosestValueInBstUtil(tree.left, target, closest);
    }

    //Doing this because if 12(target) > 10 (root) then anything less than 10 will have more distance between 12 and
    //subsequent number. So eliminating complete left side. Same for above.
    else if (tree.right != null && target > tree.value) {
      return findClosestValueInBstUtil(tree.right, target, closest);
    }
    return closest;
  }
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
