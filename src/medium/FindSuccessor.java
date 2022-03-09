package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Write a function that takes in a Binary Tree (where nodes have an additional
 pointer to their parent node) as well as a node contained in that tree and
 returns the given node's successor.

 A node's successor is the next node to be visited (immediately after the given
 node) when traversing its tree using the in-order tree-traversal technique. A
 node has no successor if it's the last node to be visited in the in-order
 traversal.

 If a node has no successor, your function should return None/Null.

 Each BinaryTree node has an integer value, a parent node, a left node and a right child node. Children nodes can either be
 BinaryTree nodes themselves or None/null.

 Sample Input:
 tree =
                    1
                  /   \
                 2     3
               /   \
              4     5
            /
           6
 node = 5

 Sample Output: 1
 // This tree's in-order traversal order is:
 // 6 -> 4 -> 2 -> 5 -> 1 -> 3
 // 1 comes immediately after 5.

 */
public class FindSuccessor {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    /* Method -1 : By using extra O(n) space by storing values in ArrayList and returning next node.
    List<BinaryTree> inOrderList = new ArrayList<>();
    this.inOrder(tree, inOrderList);

    for (int i = 0; i < inOrderList.size(); i++) {
      if ((inOrderList.get(i).value == node.value) && (i < inOrderList.size() - 1)) {
        return inOrderList.get(i + 1);
      }
    }

    return null;
    */

    /**
     * InOrder Pattern: left -> root -> right
     * get leftmost node from right side.
     * Get leftmost child if node.right != null as the successor will be on left side which will be the leftmost child.
     *
     * If node.right != null it means successor lies up in the tree as left side and direct parent node have been
     * visited. The only parent node which has not been visited is the node on whose left side given node lies
     * (as left -> root).
     */
    if(node.right != null) {
      return this.findLeftMostChild(node.right);
    }
    return this.getParentWithNodeAsLeftChild(node);
  }

  public BinaryTree findLeftMostChild(BinaryTree node) {
    BinaryTree currentNode = node;
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode;
  }

  public BinaryTree getParentWithNodeAsLeftChild(BinaryTree node) {
    BinaryTree currNode = node;
    while(currNode.parent != null && currNode.parent.left != currNode) {
      currNode = currNode.parent;
    }
    return currNode.parent;
  }

  public void inOrder(BinaryTree root, List<BinaryTree> inOrderList) {

    if (root == null) {
      return;
    }

    this.inOrder(root.left, inOrderList);
    inOrderList.add(root);
    this.inOrder(root.right, inOrderList);
  }
}
