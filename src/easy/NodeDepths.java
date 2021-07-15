package easy;

import java.util.List;

/**
 *
 The distance between a node in a Binary Tree and the tree's root is called the
 node's depth.

 Write a function that takes in a Binary Tree and returns the sum of its nodes'
 depths.

 Each BinaryTree node has an integer value, a left child node, and a right child node. Children
 nodes can either be BinaryTree nodes themselves or None/Null

 Sample Input:               =    1
                              /     \
                            2       3
                          /   \   /   \
                        4     5 6     7
                      /   \
                    8     9

 Sample Output : 16
 // The depth of the node with value 2 is 1.
 // The depth of the node with value 3 is 1.
 // The depth of the node with value 4 is 2.
 // The depth of the node with value 5 is 2.
 // Etc..
 // Summing all of these depths yields 16.
 */
public class NodeDepths {

  public static int findDepth(BinaryTree root, int depth) {
        if(root == null) {
          return 0;
        } else {
          int ldepth = findDepth(root.left, depth + 1);
          int rdepth = findDepth(root.right, depth + 1);
          if (ldepth > rdepth)
            return ldepth + 1;
          else
            return rdepth + 1;
        }
  }

  public static int nodeDepthsUtil(BinaryTree root, int totalDepth) {
    //correct will work
//    if(root == null) {
//      return 0;
//    }
//    int ldepth = nodeDepthsUtil(root.left, totalDepth + 1);
//    int rdepth = nodeDepthsUtil(root.right, totalDepth + 1);
//    totalDepth = totalDepth + ldepth + rdepth;
//    return totalDepth;

    //more concise
    if(root == null) {
      return 0;
    }
    return totalDepth + nodeDepthsUtil(root.left, totalDepth + 1) + nodeDepthsUtil(root.right, totalDepth + 1);
  }

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
    return nodeDepthsUtil(root, 0);
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  public static void main(String[] args) {
    BinaryTree root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.right = new BinaryTree(3);
    root.left.left = new BinaryTree(4);
    root.left.right = new BinaryTree(5);
    root.left.left.left = new BinaryTree(8);
    root.left.left.right = new BinaryTree(9);
    root.right.left = new BinaryTree(6);
    root.right.right = new BinaryTree(7);

    System.out.println(nodeDepths(root));
    System.out.println(findDepth(root, 0));
  }
}
