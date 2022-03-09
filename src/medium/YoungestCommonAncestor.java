package medium;

/**
 *
 You're given three inputs, all of which are instances of an AncestralTree class that have an ancestor property
 pointing to their youngest ancestor. The first input is the top ancestor in an
 ancestral tree (i.e., the only instance that has no ancestor--its ancestor property points to None/Null), and the other two inputs are descendants in the ancestral
 tree.


 Write a function that returns the youngest common ancestor to the two
 descendants.

 Note that a descendant is considered its own ancestor. So in the simple
 ancestral tree below, the youngest common ancestor to nodes A and B is node A.

 // The youngest common ancestor to nodes A and B is node A.
    A
  /
 B

 Sample Input
 // The nodes are from the ancestral tree below.</span>
 topAncestor = node A
 descendantOne = node E
 descendantTwo = node I
                      A
                   /     \
                  B       C
                /   \   /   \
               D     E F     G
             /   \
            H     I

 Sample Output
 node B

 */
public class YoungestCommonAncestor {
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    // Write your code here.
    int depth1 = findDepth(topAncestor, descendantOne);
    int depth2 = findDepth(topAncestor, descendantTwo);
    if (depth1 < depth2) {
      return findYongestAncestor(depth2-depth1, descendantOne, descendantTwo);
    } else {
      return findYongestAncestor(depth1-depth2, descendantTwo, descendantOne);
    }
  }

  public static int findDepth(AncestralTree topAncestor, AncestralTree descendant) {
    int depth = 0;
    while (descendant != topAncestor) {
      depth++;
      descendant = descendant.ancestor;
    }
    return depth;
  }

  public static AncestralTree findYongestAncestor(int diff, AncestralTree descendantOne, AncestralTree descendantTwo) {
    while (diff > 0) {
      descendantTwo = descendantTwo.ancestor;
      diff--;
    }
    // Not comparing ancestors for case topAncestor = A, descendantOne = A, descendantTwo = B ie A-B where answer is A.
    while (descendantTwo != descendantOne) {
      descendantTwo = descendantTwo.ancestor;
      descendantOne = descendantOne.ancestor;
    }
    return descendantOne;
  }


  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }

  public static void main(String[] args) {

  }
}
