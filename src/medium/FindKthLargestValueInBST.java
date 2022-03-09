package medium;

/**
 *
 Write a function that takes in a Binary Search Tree (BST) and a positive
 integer k and returns the kth largest integer contained in the
 BST.

 You can assume that there will only be integer values in the BST and that
 k is less than or equal to the number of nodes in the tree.

 Also, for the purpose of this question, duplicate integers will be treated as
 distinct values. In other words, the second largest value in a BST containing
 values {5, 7, 7} will be 7 —not 5.

 Sample Input
 tree =          15
              /     \
             5      20
           /   \   /   \
          2     5 17   22
        /   \
       1     3
 k = 3
 Sample Output: 17
 */
public class FindKthLargestValueInBST {
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    // Write your code here.
    TreeInfo treeInfo = new TreeInfo();
    this.findKthLargestValueInBstUtil(tree, k, treeInfo);
    return treeInfo.node;
  }

  //o(h+k) time and o(h) space
  public void findKthLargestValueInBstUtil(BST tree, int k, TreeInfo treeInfo) {
    if (tree == null || k == treeInfo.count) {
      return;
    }
    this.findKthLargestValueInBstUtil(tree.right, k, treeInfo);
    if(treeInfo.count < k) {
      treeInfo.count++;
      treeInfo.node = tree.value;
      this.findKthLargestValueInBstUtil(tree.left, k, treeInfo);
    }
  }

  static class TreeInfo {
    int node = -1;
    int count = 0;
  }

  public static void main(String[] args) {
    BST bst = new BST(15);
    bst.left = new BST(5);
    bst.left.left = new BST(2);
    bst.left.right = new BST(5);
    bst.left.left.left = new BST(1);
    bst.left.left.right = new BST(3);
    bst.right = new BST(20);
    bst.right.left = new BST(17);
    bst.right.right = new BST(22);

    FindKthLargestValueInBST find = new FindKthLargestValueInBST();
    System.out.println(find.findKthLargestValueInBst(bst, 5));
  }
}
