package medium;

/**
 *
 Write a function that takes in a Binary Tree and returns its diameter. The
 diameter of a binary tree is defined as the length of its longest path, even
 if that path doesn't pass through the root of the tree.

 A path is a collection of connected nodes in a tree, where no node is
 connected to more than two other nodes. The length of a path is the number of
 edges between the path's first node and its last node.

 Sample Input:
 tree =        1
             /   \
            3     2
          /   \
         7     4
        /       \
       8         5
      /           \
     9             6

 Sample Output
 6 // 9 -> 8 -> 7 -> 3 -> 4 -> 5 -> 6
 // There are 6 edges between the
 // first node and the last node
 // of this tree's longest path.
 */
public class BinaryTreeDiameter {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
    return this.getTreeInfo(tree).diameter;
  }

  public TreeInfo getTreeInfo(BinaryTree tree) {
    if (tree == null) {
      return new TreeInfo(0, 0);
    }

    TreeInfo leftTreeInfo = this.getTreeInfo(tree.left);
    TreeInfo rightTreeInfo = this.getTreeInfo(tree.right);

    int maxHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
    //Length of longest path that goes through a node = leftHeight + rightHeight
    //Diameter = max(leftDia, rightDia, leftHeight + rightHeight ie len of longest path through the node)
    int maxDiameter = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
    int currentDiameter = Math.max(maxDiameter, leftTreeInfo.height + rightTreeInfo.height);

    return new TreeInfo(currentDiameter, maxHeight);
  }
}

class TreeInfo{
  int diameter;
  int height;

  TreeInfo(int diameter, int height) {
    this.diameter = diameter;
    this.height = height;
  }
}
