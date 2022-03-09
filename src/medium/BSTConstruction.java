package medium;

/**
 *
 Write a BST class for a Binary Search Tree. The class should support:
 Inserting values with the insert method.
 Removing values with the remove method; this method should
 only remove the first instance of a given value.
 Searching for values with the contains method.

 Note that you can't remove values from a single-node tree. In other words,
 calling the remove method on a single-node tree should simply not
 do anything.

 Each BST node has an integer value, a left child node, and a right child node. A node is
 said to be a valid BST node if and only if it satisfies the BST
 property: its value is less than or equal to the values
 of every node to its right; and its children nodes are either valid
 BST nodes themselves or None/Null.

 Sample Usage
 // Assume the following BST has already been created:

                10
             /     \
            5      15
          /   \   /   \
         2     5 13   22
       /           \
      1            14

 // All operations below are performed sequentially.
 insert(12):   10
            /     \
           5      15
         /   \   /   \
        2     5 13   22
      /        /  \
     1        12  14

 remove(10):   12
            /     \
           5      15
         /   \   /   \
        2     5 13   22
      /           \
     1            14

 contains(15): true
 */
public class BSTConstruction {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insertRec(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
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


    public boolean containsRec(int value) {
      // Write your code here.
      if(value == this.value) {
        return true;
      } else if (value < this.value) {
        if(this.left == null) {
          return false;
        } else {
          return this.left.contains(value);
        }
      } else {
        if(this.right == null) {
          return false;
        } else {
          return this.right.contains(value);
        }
      }
    }

    public BST removeRec(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
      this.removeRec(value, null);
      return this;
    }

    public void removeRec(int value, BST parent) {
      if (value < this.value) {
        if (this.left != null) {
          this.left.remove(value, this);
        }
      } else if (value > this.value) {
        if (this.right != null) {
          this.right.remove(value, this);
        }
      }
      // Find the smallest value of the right subtree to replace with root/parent node or value we are trying to remove
      else {
        if (this.left != null && this.right != null) {
          // substitute the value of current node to leftmost right subtree value
          this.value = this.right.getMinValue();
          // remove the unwanted leftmost right subtree value
          this.right.remove(this.value, this);
        }
        // In this case it is the root node i.e. node which doesn't have parent node
        else if (parent == null) {
          if (this.left != null) {
            this.value = this.left.value;
            this.right = this.left.right;
            this.left = this.left.left;
          } else if (this.right != null) {
            this.value = this.right.value;
            this.left = this.right.left;
            this.right = this.right.right;
          } else {
            // This is a single node tree, do nothing
          }
        } // Cases where node to be deleted is left child of parent node and right child of parent node is null
          //    5
          //  3
         //     4
         else if (parent.left == this) {
            parent.left = this.left != null ? this.left:this.right;
        } // Cases where node to be deleted is right child of parent node and left child of parent node is null
        else if (parent.right == this) {
          parent.right = this.left != null ? this.left:this.right;
        }
      }
    }

    public BST insert(int value) {
      BST currentNode = this;

      while(true) {
        if (value < currentNode.value) {
          if (currentNode.left == null) {
            currentNode.left = new BST(value);
            break;
          }
          currentNode = currentNode.left;
        } else {
          if (currentNode.right == null) {
            currentNode.right = new BST(value);
            break;
          }
          currentNode = currentNode.right;
        }
      }

      return this;
    }

    public boolean contains(int value) {
      BST currentNode = this;
      while(currentNode != null) {
        if (value == currentNode.value) {
          return true;
        } else if (value < currentNode.value) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      return false;
    }

    public BST remove(int value) {
      this.remove(value, null);
      return this;
    }

    public void remove(int value, BST parentNode) {
      BST currentNode = this;
      while (currentNode != null) {
        if (value < currentNode.value) {
          parentNode = currentNode;
          currentNode = currentNode.left;
        }else if (value > currentNode.value) {
          parentNode = currentNode;
          currentNode = currentNode.right;
        } else {
          if (currentNode.left != null && currentNode.right != null) {
            currentNode.value = currentNode.right.getMinValue();
            currentNode.right.remove(currentNode.value, currentNode);
          } else if (parentNode == null) {
            if (currentNode.left != null) {
              currentNode.value = currentNode.left.value;
              currentNode.left = currentNode.left.left;
              currentNode.right = currentNode.left.right;
            } else if (currentNode.right != null) {
              currentNode.value = currentNode.right.value;
              currentNode.left = currentNode.right.left;
              currentNode.right = currentNode.right.right;
            } else {
              // Single node tree do nothing
            }
          } else if (parentNode.left == currentNode) {
            parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
          } else if (parentNode.right == currentNode) {
            parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
          }
          break;
        }
      }
    }

    public int getMinValue() {
      if(this.left == null) {
        return this.value;
      } else {
        return this.left.getMinValue();
      }
    }
  }
}
