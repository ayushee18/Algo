package medium;

public class HeightBalancedTree {
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
    }

    return treeInfo;
  }
}
