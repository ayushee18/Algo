package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Write a function that takes in a non-empty sorted array of distinct integers,
 constructs a BST from the integers, and returns the root of the BST.

 The function should minimize the height of the BST.

 You've been provided with a BST class that you'll have to use to
 construct the BST.

 Note that the BST class already has an insert method
 which you can use if you want.

 Sample Input
 array = [1, 2, 5, 7, 10, 13, 14, 15, 22]

 Sample Output
            10
         /     \
        2      14
      /   \   /   \
     1     5 13   15
           \       \
            7      22
 // This is one example of a BST with min height
 // that you could create from the input array.
 // You could create other BSTs with min height
 // from the same array; for example:


             10
          /     \
         5      15
       /   \   /   \
      2     7 13   22
     /           \
    1            14


 */
public class MinHeightBST {
  //long method
  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
    int mid = array.size()/2;
    BST root = new BST(array.get(mid));
    minHeightBstUtil(array, root, 0, mid);
    minHeightBstUtil(array, root, mid + 1, array.size());
    return root;
  }

  public static void minHeightBstUtil(List<Integer> array, BST root, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = (start + end)/2;
    BST rootNode = root.insert(array.get(mid));
    minHeightBstUtil(array, rootNode, start, mid);
    minHeightBstUtil(array, rootNode, mid + 1, end);
  }

  //short method which doesn't need insert method
  public static BST minHeightBinaryTree(List<Integer> array) {
    // Write your code here.
    return minHeightBinaryTreeUtil(array, 0, array.size() - 1);
  }

  public static BST minHeightBinaryTreeUtil(List<Integer> array, int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = (start + end)/2;
    BST root = new BST(array.get(mid));
    root.left = minHeightBinaryTreeUtil(array, start, mid - 1);
    root.right = minHeightBinaryTreeUtil(array, mid + 1, end);
    return root;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }

    public BST insert(int value) {
      if (value < this.value) {
        if (this.left == null) {
          this.left = new BST(value);
        } else {
          return this.left.insert(value);
        }
      } else {
        if (this.right == null) {
          this.right = new BST(value);
        } else {
          return this.right.insert(value);
        }
      }
      return this;
    }
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1); list.add(2); list.add(5); list.add(7);
    list.add(10); list.add(13); list.add(14); list.add(15); list.add(22);

    minHeightBst(list);
  }
}
