package medium;

import java.util.ArrayList;

/**
 * The pre-order traversal of a Binary Tree is a traversal technique that starts
 * at the tree's root node and visits nodes in the following order:
 * 1. Current Node, 2. Left Subtree, 3. Right Subtree
 *
 Given a non-empty array of integers representing the pre-order traversal of a
 Binary Search Tree (BST), write a function that creates the relevant BST and
 returns its root node.

 The input array will contain the values of BST nodes in the order in which
 these nodes would be visited with a pre-order traversal.

 Sample Input
 preOrderTraversal = [10, 4, 2, 1, 5, 17, 19, 18]

 Sample Output
              10
            /    \
           4      17
         /   \      \
        2     5     19
      /           /
     1           18
 *
 */
public class ReconstructBST {
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  static class TreeInfo {
    int arrayIndex;

    public TreeInfo(int arrayIndex) {
      this.arrayIndex = arrayIndex;
    }
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    // Write your code here.
    return this.reconstructBstUtil(preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE, new TreeInfo(0));
  }

  public BST reconstructBstUtil(ArrayList<Integer> preOrderTraversalValues, int lower, int upper, TreeInfo treeInfo) {
    // Means all elements in the array are traversed.
    if(preOrderTraversalValues.size() == treeInfo.arrayIndex) {
      return null;
    }
    int value = preOrderTraversalValues.get(treeInfo.arrayIndex);
    // value >= upper because if [3, 3] comes move last 3 as right child of 1st 3
    if(value < lower || value >= upper) {
      return null;
    }
    treeInfo.arrayIndex++;
    BST leftSubtree = this.reconstructBstUtil(preOrderTraversalValues, lower, value, treeInfo);
    BST rightSubtree = this.reconstructBstUtil(preOrderTraversalValues, value, upper, treeInfo);

    BST root = new BST(value);
    root.left = leftSubtree;
    root.right = rightSubtree;

    return root;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(10); list.add(4); list.add(2); list.add(1);
    list.add(5); list.add(17); list.add(19); list.add(18);
 //       list.add(2); list.add(0); list.add(1); list.add(4); list.add(3); list.add(3);

    ReconstructBST reconstructBST = new ReconstructBST();
    BST bst = reconstructBST.reconstructBst(list);
    System.out.println(bst.value);
  }
}
