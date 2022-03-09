package medium;

public class HeightBalancedBinaryTree {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class TreeInfo {
    int height;
    boolean isBalanced;
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    return this.isBalanced(tree, new TreeInfo()).isBalanced;
  }

  public TreeInfo isBalanced(BinaryTree root, TreeInfo treeInfo) {
    if(root == null) {
      treeInfo.height = 0;
      treeInfo.isBalanced = true;
      return treeInfo;
    }

    TreeInfo ltreeInfo = new TreeInfo();
    TreeInfo rtreeInfo = new TreeInfo();

    ltreeInfo.height = 1 + this.isBalanced(root.left, ltreeInfo).height;
    rtreeInfo.height = 1 + this.isBalanced(root.right, rtreeInfo).height;

    int diff = Math.abs(ltreeInfo.height - rtreeInfo.height);

    if(diff > 1) {
      treeInfo.isBalanced = false;
    } else {
      treeInfo.isBalanced = true;
      treeInfo.isBalanced = ltreeInfo.isBalanced && rtreeInfo.isBalanced;
    }
    treeInfo.height = Math.max(ltreeInfo.height, rtreeInfo.height);
    return treeInfo;
  }

  //Does the same thing with same logic but is more concise, readable and more production ready
//  public TreeInfo isBalanced(BinaryTree root) {
//    if(root == null) {
//      return new TreeInfo(true, 0);
//    }
//
//    TreeInfo leftTreeInfo = isBalanced(root.left);
//    TreeInfo rightTreeInfo = isBalanced(root.right);
//
//    boolean isBalanced = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced
//        && Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1;
//
//    int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
//
//    return new TreeInfo(isBalanced, height);
//  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(1);
    binaryTree.left = new BinaryTree(2);
    binaryTree.left.left = new BinaryTree(4);
    binaryTree.left.right = new BinaryTree(5);
    binaryTree.left.right.left = new BinaryTree(7);
    binaryTree.left.right.right = new BinaryTree(8);
    binaryTree.right = new BinaryTree(3);
    binaryTree.right.right = new BinaryTree(6);
    binaryTree.right.right.left = new BinaryTree(9);
    binaryTree.right.right.right = new BinaryTree(10);

    HeightBalancedBinaryTree heightBalancedBinaryTree = new HeightBalancedBinaryTree();
    System.out.println(heightBalancedBinaryTree.heightBalancedBinaryTree(binaryTree));
  }
}
