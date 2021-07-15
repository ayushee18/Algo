package medium;

import java.util.ArrayList;
import java.util.List;

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

//  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
//    // Write your code here.
//    return this.reconstructBstUtil(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, 0);
//  }

  public BST reconstructBstUtil(int lowerBound, int upperBound, ArrayList<Integer> preOrderTraversalValues,
                                int rootIdx) {

    if (rootIdx == preOrderTraversalValues.size()) {
      return null;
    }

    int rootVal = preOrderTraversalValues.get(rootIdx);

    if (rootVal < lowerBound || rootVal >= upperBound) {
      return null;
    }

    rootIdx++;

    BST leftSubtree = this.reconstructBstUtil(lowerBound, rootVal, preOrderTraversalValues, rootIdx);
    BST rightSubtree = this.reconstructBstUtil(rootVal, upperBound, preOrderTraversalValues, rootIdx);

    BST bst = new BST(rootVal);
    bst.left = leftSubtree;
    bst.right = rightSubtree;

    return bst;
  }

  static class TreeInfo {
    public int rootIdx;

    public TreeInfo(int rootIdx) {
      this.rootIdx = rootIdx;
    }
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    // Write your code here.
    TreeInfo treeInfo = new TreeInfo(0);
    return this.reconstructBstUtil(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
  }

  public BST reconstructBstUtil(int lowerBound, int upperBound, ArrayList<Integer> preOrderTraversalValues,
                                TreeInfo currentSubtreeInfo) {

    if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size() ) {
      return null;
    }

    int rootVal = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);

    if (rootVal < lowerBound || rootVal >= upperBound) {
      return null;
    }

    currentSubtreeInfo.rootIdx += 1;

    BST leftSubtree = this.reconstructBstUtil(lowerBound, rootVal, preOrderTraversalValues, currentSubtreeInfo);
    BST rightSubtree = this.reconstructBstUtil(rootVal, upperBound, preOrderTraversalValues, currentSubtreeInfo);

    BST bst = new BST(rootVal);
    bst.left = leftSubtree;
    bst.right = rightSubtree;

    return bst;
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(10); list.add(4); list.add(2); list.add(1);
    list.add(5); list.add(17); list.add(19); list.add(18);

    ReconstructBST reconstructBST = new ReconstructBST();
    BST bst = reconstructBST.reconstructBst(list);
    System.out.println(bst);
  }
}
