package medium;

/**
 *
 Write a function that takes in a Binary Tree and inverts it. In other words,
 the function should swap every left node in the tree for its corresponding
 right node.

 Sample Input
 tree =    1
        /     \
       2       3
     /   \   /   \
    4     5 6     7
  /   \
 8     9

 Sample Output
         1
      /     \
     3       2
   /   \   /   \
  7     6 5     4
              /   \
             9     8
 */
public class InvertBinaryTree {
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
    if(tree == null) {
      return;
    }
    BinaryTree temp = tree.left;
    tree.left = tree.right;
    tree.right = temp;
    invertBinaryTree(tree.left);
    invertBinaryTree(tree.right);
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
