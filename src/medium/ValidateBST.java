package medium;

/**
 *
 Write a function that takes in a potentially invalid Binary Search Tree (BST)
 and returns a boolean representing whether the BST is valid.

 Each BST node has an integer value, a left child node, and a right child node. A node is
 said to be a valid BST node if and only if it satisfies the BST
 property: its value is strictly greater than the values of every
 node to its left; its value is less than or equal to the values
 of every node to its right; and its children nodes are either valid
 BST nodes themselves or None/Null.

 A BST is valid if and only if all of its nodes are valid BST nodes.

 Sample Input
 tree  =   10
        /     \
       5      15
     /   \   /   \
    2     5 13   22
  /           \
 1            14

 Sample Output: true

 */
public class ValidateBST {
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return validateBstUtil(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean validateBstUtil(BST tree, int minVal, int maxVal) {
    if (tree == null) {
      return true;
    }
    if (tree.value >= maxVal || tree.value < minVal) {
      return false;
    }
    if (tree.left != null && !validateBstUtil(tree.left, minVal, tree.value)) {
      return false;
    }
    if (tree.right != null && !validateBstUtil(tree.right, tree.value, maxVal)) {
      return false;
    }
    return true;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    BST tree = new BST(3);
    tree.left = new BST(2);
    tree.right = new BST(5);
    //tree.left.left = new BST(1);
    //tree.left.right = new BST(6);
    tree.right.left = new BST(2);
    tree.right.right = new BST(6);

    System.out.println(validateBst(tree));
  }
}
